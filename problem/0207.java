class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // init graph
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList());
        for(int[] pair: prerequisites) graph.get(pair[0]).add(pair[1]);
        // init visited record
        int[] visited = new int[numCourses];
        for(int course = 0; course < numCourses; course++)
            // check previous courses lead to loop or not
            if(isLoop(graph, visited, course)) 
                return false;        
        return true;
    }
    
    private boolean isLoop(List<List<Integer>> graph, int[] visited, int course) {
        // if visit the visited course, there is a loop 
        if(visited[course] == -1) return true;
        // if the course already visited done, return directly
        if(visited[course] == 1) return false;
        // course being visited
        visited[course] = -1;
        for(int preCourse: graph.get(course)) 
            // check previous required course
            if(isLoop(graph, visited, preCourse)) 
                return true; 
        // course done visited
        visited[course] = 1;
        return false;
    }
}
