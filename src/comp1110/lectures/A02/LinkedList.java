package comp1110.lectures.A02;

import comp1110.lectures.A01.List;

public class LinkedList<T> implements List<T> {

    private LLNode first, last;

    class LLNode {
        T value;
        LLNode next;

        LLNode(T value, LLNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next != null) {
                return value.toString() + " " + next.toString();
            } else {
                return value.toString();
            }
        }

        T getLL(int index) {
            if (index == 0) {
                return value;
            } else {
                if (next == null) {
                    throw new IndexOutOfBoundsException("Tried to traverse past the end of the list");
                }
                return next.getLL(index - 1);
            }
        }
    }

    @Override
    public void add(T value) {
        LLNode newNode = new LLNode(value, null);
        if (first == null) {
            // list is empty
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public T get(int index) {
        if (first == null) {
            throw new IndexOutOfBoundsException("Tried to get from empty list");
        }
        return first.getLL(index);
        /*
        // non-recursive version
        int i = 0;
        LLNode node = first;
        while (node != null) {
            if (i == index) {
                return node.value;
            }
            node = node.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Invalid index:" + index);
        */
    }

    @Override
    public int size() {
        int size = 0;
        LLNode node = first;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void reverse() {

    }
}
