package comp1110.lectures.A04;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {
    private static final int DEFAULT_SIZE = 4;
    LinkedList<T>[] table;
    private int numElements = 0;

    public HashSet() {
        table = new LinkedList[DEFAULT_SIZE];
    }

    @Override
    public boolean add(T element) {
        if (element == null) return false;
        int hashCode = element.hashCode();
        int bucket = hashCode % 4;
        if (table[bucket] == null) table[bucket] = new LinkedList<>();
        if (!table[bucket].contains(element)) {
            table[bucket].add(element);
            numElements++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) return false;
        int hashCode = element.hashCode();
        int bucket = hashCode % 4;
        if (table[bucket] != null) {
            boolean removed = table[bucket].remove(element);
            if (removed) numElements--;
            return removed;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) return false;
        int hashCode = element.hashCode();
        int bucket = hashCode % 4;
        if (table[bucket] != null) {
            return table[bucket].contains(element);
        }
        return false;
    }

    @Override
    public int size() {
        return numElements;
    }
}
