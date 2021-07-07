package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {

    ListImpl list;

    public QueueImpl(){
        list = new ListImpl();
    }


    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return list.iterator().hasNext();
        }

        @Override
        public Object next() {
            return list.iterator().next();
        }

    }

    @Override
    public void enqueue(Object element) {
        list.addLast(element);
    }

    @Override
    public Object dequeue() {
        try {
            Object o = list.getFirst();
            list.removeFirst();
            return o;
        }catch (NullPointerException exception){
            return null;
        }
    }

    @Override
    public Object top() {

        return list.getFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        for(String arg: args){
            queue.enqueue(arg);
        }
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
        queue.clear();
        System.out.println(queue.toString());

    }

}
