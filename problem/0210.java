// leetcode example solution, DFS
class Solution {
  static int WHITE = 1;
  static int GRAY = 2;
  static int BLACK = 3;

  boolean isPossible;
  Map<Integer, Integer> color;
  Map<Integer, List<Integer>> adjList;
  List<Integer> topologicalOrder;

  private void init(int numCourses) {
    this.isPossible = true;
    this.color = new HashMap<Integer, Integer>();
    this.adjList = new HashMap<Integer, List<Integer>>();
    this.topologicalOrder = new ArrayList<Integer>();

    // By default all vertces are WHITE
    for (int i = 0; i < numCourses; i++) {
      this.color.put(i, WHITE);
    }
  }

  private void dfs(int node) {

    // Don't recurse further if we found a cycle already
    if (!this.isPossible) {
      return;
    }

    // Start the recursion
    this.color.put(node, GRAY);

    // Traverse on neighboring vertices
    for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
      if (this.color.get(neighbor) == WHITE) {
        this.dfs(neighbor);
      } else if (this.color.get(neighbor) == GRAY) {
        // An edge to a GRAY vertex represents a cycle
        this.isPossible = false;
      }
    }

    // Recursion ends. We mark it as black
    this.color.put(node, BLACK);
    this.topologicalOrder.add(node);
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {

    this.init(numCourses);

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);
    }

    // If the node is unprocessed, then call dfs on it.
    for (int i = 0; i < numCourses; i++) {
      if (this.color.get(i) == WHITE) {
        this.dfs(i);
      }
      // If found any cyclic, then return immediately
      if (!this.isPossible) return new int[0];
    }
    // Reverse the order
    Collections.reverse(this.topologicalOrder);
    return this.topologicalOrder.stream().mapToInt(i -> i).toArray();
  }
}

// leetcode example solution, node indegree
class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    boolean isPossible = true;
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    int[] indegree = new int[numCourses];
    int[] topologicalOrder = new int[numCourses];

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);

      // Record in-degree of each vertex
      indegree[dest] += 1;
    }

    // Add all vertices with 0 in-degree to the queue
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int i = 0;
    // Process until the Q becomes empty
    while (!q.isEmpty()) {
      int node = q.remove();
      topologicalOrder[i++] = node;

      // Reduce the in-degree of each neighbor by 1
      if (adjList.containsKey(node)) {
        for (Integer neighbor : adjList.get(node)) {
          indegree[neighbor]--;

          // If in-degree of a neighbor becomes 0, add it to the Q
          if (indegree[neighbor] == 0) {
            q.add(neighbor);
          }
        }
      }
    }

    // Check to see if topological sort is possible or not.
    if (i == numCourses) {
      return topologicalOrder;
    }

    return new int[0];
  }
}

// method 1, dfs
class Solution {
    Map<Integer, List<Integer>> adjacent;
    Map<Integer, Integer> courseStatus;
    List<Integer> topologicalOrder;
    boolean inValid;
    int WAIT = 0;
    int PICKED = -1;
    int DONE = 1;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // init
        adjacent = new HashMap();
        courseStatus = new HashMap();
        topologicalOrder = new ArrayList();
        inValid = false;
        
        for (int[] pair: prerequisites) {
            int preCourse = pair[1];
            int course = pair[0];
            List<Integer> courseAdjacent = adjacent.getOrDefault(preCourse, new ArrayList<Integer>());
            courseAdjacent.add(course);
            adjacent.put(preCourse, courseAdjacent);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (courseStatus.getOrDefault(i, WAIT) == WAIT) dfsTake(i);
            if (inValid) return new int[0];
        }
        // reverse order
        Collections.reverse(topologicalOrder);
        return topologicalOrder.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void dfsTake(int course) {
        // if found a cycle
        if (inValid) return;         
        // being take
        courseStatus.put(course, PICKED);
        for (int neighbor : adjacent.getOrDefault(course, new ArrayList<Integer>())) {
            if (courseStatus.getOrDefault(neighbor, WAIT) == PICKED) inValid = true;
            else if (courseStatus.getOrDefault(neighbor, WAIT) == WAIT) dfsTake(neighbor);
        }
        // being done
        courseStatus.put(course, DONE);
        topologicalOrder.add(course);
    }
}

// method 1, indegree
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // init
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjacent = new HashMap();
        // create topological graph
        for (int[] pair: prerequisites) {
            int course = pair[0];
            int preRequired = pair[1];
            List<Integer> adjacentCourse = adjacent.getOrDefault(preRequired, new ArrayList<Integer>());
            adjacentCourse.add(course);
            adjacent.put(preRequired, adjacentCourse);
            indegree[course]++;
        }
        
        // push 0-degree's course to queue
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) que.offer(i);
        }
        
        int[] topologicalOrder = new int[numCourses];
        int i = 0;
        while (!que.isEmpty()) {
            int course = que.poll();
            topologicalOrder[i++] = course;            
            for (int neighbor : adjacent.getOrDefault(course, new ArrayList<Integer>())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) que.offer(neighbor);
            }
        }
        // if found a loop, i will not equals numCourses
        return (i == numCourses) ? topologicalOrder : new int[0];
    }
}