package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ListImpl implements List {

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
    public void addFirst(Object element) {
        
    }

    @Override
    public void addLast(Object element) {
        
    }

    @Override
    public void removeFirst() {
        
    }

    @Override
    public void removeLast() {
        
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object search(Object element) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {

    }
}
