package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {

    public QueueImpl() {
        
    }

    @Override
    public void clear() {
        
    }

    @Override
    public int size() {
        return 0;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

    }

    @Override
    public void enqueue(Object element) {
        
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object top() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {

    }

}
