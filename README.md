

Practical task #2

_______________________

Note: You are not allowed to use any types from java.util package except for these two:

1) java.util.Iterator

2) java.util.NoSuchElementException

_______________________

Create Container interface and place it in the root package (com.epam.rd.java.basic.practice2)

_______________________

package com.epam.rd.java.basic.practice2;

public interface Container extends Iterable<Object> {

    // Removes all of the elements. 

    void clear(); 

    // Returns the number of elements.  

    int size();    

    // Returns a string representation of this container.  

    String toString(); 

    // Returns an iterator over elements. 

    // Iterator must implements the remove method. 

    Iterator<Object> iterator(); 

}

_______________________

Task 1

_______________________

Type names: Array, ArrayImpl

_______________________

1.1 Create Array interface containing the following:

_______________________

package com.epam.rd.java.basic.practice2;  

public interface Array extends Container {   

    // Add the specified element to the end.  

    void add(Object element);   

    // Sets the element at the specified position. 

    void set(int index, Object element);   

    // Returns the element at the specified position. 

    Object get(int index);  

    // Returns the index of the first occurrence of the specified element,  

    // or -1 if this array does not contain the element.  

    // (use "equals" method to check an occurrence)  

    int indexOf(Object element);  

    // Removes the element at the specified position.  

    void remove(int index); 

 

}

_______________________

1.2. Create ArrayImpl class that implements the Array interface.

Implement the storage of the objects inside the container using an array of objects.

The method "iterator" should return an instance of the IteratorImpl class that implements java.util.Iterator<Object> interface. 

IteratorImpl class should be defined inside the ArrayImpl class (it is to be an inner class).

In case the three elements A, B, C were added to the container using ‘add’ method, then:

1) ‘toString’ method should return the following string: "[A, B, C]"

2) the elements iteration order should be: A B C

1.3. In the ArrayImpl class, create "main" method where you should demonstrate the functionality of:

1) all the methods of the Array interface (including those inherited from Container and Iterable);

2) all the methods of the Iterator interface (hasNext/next/remove).

_______________________

Task 2

_______________________

Package name: com.epam.rd.java.basic.practice2

Type names: List, ListImpl

_______________________

2.1. Create a List interface containing the following: 

_______________________

package com.epam.rd.java.basic.practice2

public interface List extends Container { 

    // Inserts the specified element at the beginning.

    void addFirst(Object element); 

    // Appends the specified element to the end.

    void addLast(Object element);  

    // Removes the first element.  

    void removeFirst();  

    // Removes the last element. 

    void removeLast();  

    // Returns the first element.

    Object getFirst();   

    // Returns the last element.  

    Object getLast();  

    // Returns the first occurrence of the specified element.

    // Returns null if no such element. 

    // (use "equals" method to check an occurrence)  

    Object search(Object element);  

    // Removes the first occurrence of the specified element. 

    // Returns true if this list contained the specified element.

    // (use "equals" method to check an occurrence)  

    boolean remove(Object element); 

}

_______________________

Storage of the objects inside the container should be implemented by using set of nodes - instances of the Node class.

Each node stores an object and a reference to the next node.

Node class should be defined inside the ListImpl class (it should be a static nested class).

The "iterator" method should return an instance of the IteratorImpl class that implements java.util.Iterator<Object> interface.

The IteratorImpl class should be defined inside the ListImpl class (it should be an inner class).

In case the three elements A, B, C were added to the container using the "addLast" method, then:

1) toString method should return the following string "[A, B, C]"

2) the elements iteration order should be: A B C

2.3 In the ListImpl class, create "main" method where you should demonstrate the functionality of:

1) all the methods from the List interface (including those inherited from Container and Iterable);

2) all the methods of the Iterator interface (hasNext/next/remove).

_______________________

Task 3

_______________________

Type names: Queue, QueueImpl

_______________________

3.1.  Create Queue interface containing the following:

_______________________

public interface Queue extends Container {  

    // Appends the specified element to the end.  

    void enqueue(Object element);  

    // Removes the head.  

    Object dequeue();   

    // Returns the head. 

    Object top();  

}

_______________________

3.2. Create QueueImpl class that implements the Queue interface.

In case the three elements A, B, C were added to the container using the "enqueue" method, then:

1) toString method should return the following string "[A, B, C]”

2) the elements iteration order should be: A B C

3.3 In the QueueImpl class, create "main" method where you should demonstrate the functionality of:

1) all the methods from the Queue interface (including those inherited from Container and Interable);

2) all the methods of the Iterator interface (hasNext/next/remove).

_______________________

Task 4

_______________________

Type names: Stack, StackImpl

_______________________

4.1.  Create Stack interface containing the following:

_______________________

package com.epam.rd.java.basic.practice2; 

public interface Stack extends Container {   

    // Pushes the specified element onto the top.  

    void push(Object element);    

    // Removes and returns the top element. 

    Object pop();   

    // Returns the top element. 

    Object top();  

}

_______________________

4.2. Create StackImpl class that implements the Stack interface.

In case the three elements  A, B, C were added to the container using ‘push’ method , then:

1)   toString method should return the following string "[A, B, C]"

3) the elements iteration order should be: C B A

4.3. In the StackImpl class, create ‘main’ method where you should demonstrate the functionality of:

1) all the methods from the Stack interface (including those inherited from Container and Interable);

2) all the methods of the Iterator interface (hasNext/next/remove).

_______________________

Notes.

1. The result should be presented as a project named Practice2.

2. The root package for all the classes: com.epam.rd.java.basic.practice2
