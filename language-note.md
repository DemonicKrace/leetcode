# Language Note

## Java

### Comparator
- custom defined compare logic
```
Ex 1:
Integer[] arr = new Integer[]{2, 3, 1, 4, 0};
Arrays.sort(arr, new Comparator<Integer>(){
    @Override
    public int compare(Integer o1, Integer o2) {
        // -1 : o1 < o2
        //  0 : o1 == o2
        // +1 : o1 > o2
        return o1.compareTo(o2);
    }
});
// arr = [0, 1, 2, 3, 4]

Ex 2:
// use lambda
Integer[] arr = new Integer[]{2, 3, 1, 4, 0};
Arrays.sort(arr, (o1, o2) -> { 
    // -1 : o1 < o2
    //  0 : o1 == o2
    // +1 : o1 > o2
    return o2.compareTo(o1);
});
// arr = [4, 3, 2, 1, 0]
```
### Arrays

```
method Arrays.asList(T... a), returns a "fixed-size" List as of size of a given array

Ex 1:
String[] letters = { "a", "b", "c", "d" }; 
List<String> letterList = Arrays.asList(letters); 
letterList.add("e"); // it will throw an UnsupportedOperationException

Ex 2:
// other soultion, use ArrayList
String[] letters = { "a", "b", "c", "d" }; 
List<String> letterList = new ArrayList<>(Arrays.asList(letters)); 
letterList.add("e"); // it is ok

```

#### binarySearch(T[] a, T key, Comparator<? super T> c)
- This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1)

```
Ex 1:
int[] arr = new int[]{1, 3, 5, 7, 9};
int index1 = Arrays.binarySearch(arr, 5); // index1 = 2
int index2 = Arrays.binarySearch(arr, 5); // index2 = -4 (-3 - 1)
```

### HashMap
```
method put(key, value), key and value can be 'null'

Ex 1:
Map<T k, T v> map = new HashMap();
map.put(null, null); // it is ok

```

### ArrayDeque
```
method add(value), value can not be 'null'

Ex 1: 
Queue<T v> que = new ArrayDeue();
que.add(null); // it will throw an exception

Ex 2:
// other soultion, use LinkedList<T>
Queue<T> que = new LinkedList();
que.add(null); // it is ok

```

## Python

### itertools

#### groupby
```

Ex 1:
teamList = [("team1", 1), ("team1", 2), ("team2", 3), ("team2", 4)]
teamGroup = {}
for key, group in itertools.groupby(teamList, lambda x: x[0]):
	teamGroup[key] = list(group)
# teamGroup = {'team1': [('team1', 1), ('team1', 2)], 'team2': [('team2', 3), ('team2', 4)]}

Ex 2:
for key, group in itertools.groupby("aabac"):
	print(key, list(group))
# a ['a', 'a']
# b ['b']
# a ['a']
# c ['c']
```
### bisect 
- binary search
<hr> 

#### prerequisite 
- array values should be `ascending` order
#### function
- find the position should be inserted
#### time complexity
-  O(logN)
```
# bisect.bisect_left(a, x, lo=0, hi=len(a), *, key=None)
# bisect.bisect_right(a, x, lo=0, hi=len(a), *, key=None)
# bisect.bisect(a, x, lo=0, hi=len(a), *, key=None)

# pos =  0  1  2  3  4  5  6
array = [1, 2, 3, 3, 3, 4, 5]

# index = 2, "left" to "right", return first should be inserted position
index = bisect.bisect_left(array, 3)

# index = 5, "right" to "left", return first should be inserted position
index = bisect.bisect_right(array, 3)

# index = 5, similar to bisect_right, all(val <= x for val in array[0 : index]) for the left side and all(val > x for val in array[index : 7]) for the right side.
index = bisect.bisect(array, 3)
```
<hr> 

#### prerequisite 
- array values should be `ascending` order
#### function
- use binary search to insert value into array
#### time complexity
-  O(N logN)
```
# bisect.insort_left(a, x, lo=0, hi=len(a), *, key=None)
# bisect.insort_right(a, x, lo=0, hi=len(a), *, key=None)
# bisect.insort(a, x, lo=0, hi=len(a), *, key=None)

# pos =  0  1  2  3  4  5  6
array = [1, 2, 3, 3, 3, 4, 5]

# use bisect_left to find postition and insert into array
#   pos =  0  1   2   3  4  5  6  7
# array = [1, 2, '3', 3, 3, 3, 4, 5]
index = bisect.insort_left(array, 3)

# use bisect_right to find postition and insert into array
#   pos =  0  1  2  3  4   5   6  7
# array = [1, 2, 3, 3, 3, '3', 4, 5]
index = bisect.insort_right(array, 3)

# use bisect to find postition and insert into array
#   pos =  0  1  2  3  4   5   6  7
# array = [1, 2, 3, 3, 3, '3', 4, 5]
index = bisect.insort(array, 3)
```
## C++
