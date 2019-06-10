package comp1110.lectures.A04;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public abstract class SetTest {

    public abstract <T extends Comparable<T>> Set<T> createSet();

    @Test
    public void testAdd() {
        Set<Integer> set = createSet();  //new HashSet<>();  不管用什么样形式去创建interface, 终究逃不开实体化的过程
        assertTrue(set.add(42));
        assertEquals(1, set.size());
        assertFalse(set.add(42));
        assertEquals(1, set.size());
        assertFalse(set.add(null));
        checkSetContents(new Integer[]{42}, set);
    }

    @Test
    public void testRemove() {
        Set<Integer> set = createSet();
        assertFalse(set.remove(42));
        assertEquals(0, set.size());
        checkSetContents(new Integer[0], set);
        set.add(42);
        set.add(17);
        assertEquals(2, set.size());
        checkSetContents(new Integer[]{17, 42}, set);
        assertTrue(set.remove(42));
        assertEquals(1, set.size());
        checkSetContents(new Integer[]{17}, set);
        assertFalse(set.remove(42));
        assertEquals(1, set.size());
        checkSetContents(new Integer[]{17}, set);
        assertFalse(set.remove(null));
        checkSetContents(new Integer[]{17}, set);
    }

    @Test
    public void testContains() {
        Set<Integer> set = createSet();
        assertFalse(set.contains(42));
        set.add(31);
        set.add(19);
        assertTrue(set.contains(31));
        assertTrue(set.contains(19));
        assertFalse(set.contains(null));
        set.remove(31);
        assertFalse(set.contains(31));
        assertTrue(set.contains(19));
    }

    private void checkSetContents(Integer[] expected, Set<Integer> set) {
        Object[] values = set.toArray();
        Arrays.sort(values);
        assertArrayEquals(expected, values);
    }
}
