package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {

    ListImpl list;

    public QueueImpl(ListImpl list) {
        this.list = list;
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
        Object o = list.getFirst();
        list.removeFirst();
        return o;
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
        ListImpl list = new ListImpl();
        QueueImpl queue = new QueueImpl(list);
        for(String arg: args){
            queue.enqueue(arg);
        }
        System.out.println(queue.toString());
    }

}
