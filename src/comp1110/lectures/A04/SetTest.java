package comp1110.lectures.A04;

import org.junit.Test;

import static junit.framework.TestCase.*;

public abstract class SetTest {

    public abstract <T> Set<T> createSet();

    @Test
    public void testAdd() {
        Set<Integer> set = createSet();
        assertTrue(set.add(42));
        assertEquals(1, set.size());
        assertFalse(set.add(42));
        assertEquals(1, set.size());
        assertFalse(set.add(null));
    }

    @Test
    public void testRemove() {
        Set<Integer> set = createSet();
        assertFalse(set.remove(42));
        assertEquals(0, set.size());
        set.add(42);
        set.add(17);
        assertEquals(2, set.size());
        assertTrue(set.remove(42));
        assertEquals(1, set.size());
        assertFalse(set.remove(42));
        assertEquals(1, set.size());
        assertFalse(set.remove(null));
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
}
