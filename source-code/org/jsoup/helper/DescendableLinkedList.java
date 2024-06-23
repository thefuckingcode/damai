package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DescendableLinkedList<E> extends LinkedList<E> {
    @Override // java.util.LinkedList, java.util.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E peekLast() {
        if (size() == 0) {
            return null;
        }
        return getLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E pollLast() {
        if (size() == 0) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingIterator(size());
    }

    private class DescendingIterator<E> implements Iterator<E> {
        private final ListIterator<E> iter;

        private DescendingIterator(int i) {
            this.iter = DescendableLinkedList.this.listIterator(i);
        }

        public boolean hasNext() {
            return this.iter.hasPrevious();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.iter.previous();
        }

        public void remove() {
            this.iter.remove();
        }
    }
}
