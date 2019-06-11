package comp1110.lectures.A06;

import comp1110.lectures.A04.Set;
import org.junit.Test;

import static junit.framework.TestCase.*;

public abstract class MapTest {
    public abstract <K extends Comparable<K>, V> Map<K, V> createMap();

    @Test
    public void testPut() {
        Map<String, Double> map = createMap();
        assertNull(map.put("apple", 2.00));
        assertEquals(1, map.size());
        assertNull(map.put("banana", 2.00));
        assertEquals(2, map.size());
        Set<String> keys = map.getKeys();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("apple"));
        assertTrue(keys.contains("banana"));
        assertEquals(2.00, map.put("banana", 5.00));
        assertEquals(2, map.size());
        keys = map.getKeys();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("apple"));
        assertTrue(keys.contains("banana"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullKey() {
        Map<String, Double> map = createMap();
        map.put(null, 1.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullValue() {
        Map<String, Double> map = createMap();
        map.put("apple", null);
    }

    @Test
    public void testGet() {
        Map<String, Double> map = createMap();
        map.put("apple", 2.00);
        map.put("banana", 5.00);
        assertEquals(map.get("apple"), 2.00);
        assertEquals(map.get("banana"), 5.00);
        assertNull(map.get("orange"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGettNullKey() {
        Map<String, Double> map = createMap();
        map.get(null);
    }

    @Test
    public void testRemove() {
        Map<String, Double> map = createMap();
        map.put("apple", 2.00);
        map.put("banana", 5.00);
        map.put("watermelon", 1.00);
        map.put("strawberry", 3.00);
        map.put("pear",1.50);
        map.put("mango", 4.00);
        map.put("apricot", 2.50);
        map.put("kiwi", 3.50);
        map.put("manderin", 4.50);
        map.put("orange", 0.50);
        map.put("dragon", 6.00);
        map.put("bread", 3.20);
        map.put("egg", 7.00);
        map.put("meat", 8.00);

       // Set<String> keys = map.getKeys();
        assertTrue(map.remove("egg"));
        assertTrue(map.remove("bread"));
       // assertEquals(12, map.size());
        //System.out.println(keys.size());
        //keys = map.getKeys();
        //assertEquals(13,keys.size());

        /*
        assertTrue(keys.contains("apple"));
        assertTrue(keys.contains("banana"));
        assertTrue(keys.contains("watermelon"));
        assertTrue(keys.contains("strawberry"));
        assertTrue(keys.contains("pear"));
        assertTrue(keys.contains("mango"));
        assertTrue(keys.contains("apricot"));
        assertTrue(keys.contains("kiwi"));
        assertTrue(keys.contains("orange"));
        assertTrue(keys.contains("dragon"));
        assertTrue(keys.contains("manderin"));
        //assertTrue(keys.contains("bread"));
        assertTrue(keys.contains("meat")); */

    }

    /*
     assertEquals(2, map.size());
        Set<String> keys = map.getKeys();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("apple"));
        assertTrue(keys.contains("banana"));

        assertFalse(map.remove("orange"));
        assertEquals(2, map.size());
        keys = map.getKeys();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("apple"));
        assertTrue(keys.contains("banana"));

        assertTrue(map.remove("apple"));
        assertEquals(1, map.size());
        keys = map.getKeys();
        assertEquals(1, keys.size());
        assertFalse(keys.contains("apple"));
        assertTrue(keys.contains("banana"));

        assertTrue(map.remove("banana"));
        assertEquals(0, map.size());
        keys = map.getKeys();
        assertEquals(0, keys.size());
        assertFalse(keys.contains("apple"));
        assertFalse(keys.contains("banana"));
     */

    @Test
    public void testClear() {
        Map<String, Double> map = createMap();
        map.put("apple", 2.00);
        map.put("banana", 5.00);
        map.clear();
        assertEquals(0, map.size());
        Set<String> keys = map.getKeys();
        assertEquals(0, keys.size());
        assertFalse(keys.contains("apple"));
        assertFalse(keys.contains("banana"));
    }
}
