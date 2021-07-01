package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {

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
    public void push(Object element) {
        
    }

    @Override
    public Object pop() {
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
