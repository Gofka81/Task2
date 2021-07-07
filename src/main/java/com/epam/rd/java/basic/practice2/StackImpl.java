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

        private  int index = size()-1;
        private int prevIndex = -1;

        @Override
        public boolean hasNext() {
            return index>=0;
        }

        @Override
        public Object next() {
            prevIndex = index;
            index--;
            return array.get(prevIndex);
        }

    }

    @Override
    public void push(Object element) {
        array.add(element);
    }

    @Override
    public Object pop() {
        try {
            Object[] temp = array.getArrayData();
            Object o = temp[array.size() - 1];
            System.arraycopy(temp, array.size(), temp, array.size() - 2, array.size() - 1);
            array.setSize(size() - 1);
            return o;
        }catch (ArrayIndexOutOfBoundsException exception){
            return null;
        }
    }

    @Override
    public Object top() {
        return array.get(size()-1);
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
        stack.pop();
        System.out.println(stack.toString());
        stack.clear();
    }

}
