package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {

   ArrayImpl array;

    public StackImpl(){
        array = new ArrayImpl();
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public int size() {
        return array.size();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return array.iterator().hasNext();
        }

        @Override
        public Object next() {
            return array.iterator().next();
        }

    }

    @Override
    public void push(Object element) {
        array.add(element);
    }

    @Override
    public Object pop() {
        Object o = array.arrayData[array.size-1];
        Object[]temp = array.arrayData;
        System.arraycopy(temp, array.size, temp, array.size-2, array.size-1);
        array.size--;
        return o;
    }

    @Override
    public Object top() {
        return array.arrayData[0];
    }

    @Override
    public String toString() {

        return array.toString();
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        for(String arg: args){
            stack.push(arg);
        }
        System.out.println(stack.toString());
    }

}
