package comp1110.lectures.A04;

public class HashSetTest extends SetTest {
    @Override
    public <T extends Comparable<T>> Set<T> createSet() {
        return new HashSet<>();  // 在此处 将interface set 实例至HashSet

    }
}
