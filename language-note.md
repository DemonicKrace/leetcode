# Language Note

## Java

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
que.add(null); // it will throw a exception

// other soultion, use LinkedList<T>
Queue<T> que = new LinkedList();
que.add(null); // it is ok

```

## Python
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
- use binary search to insert value to array
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
