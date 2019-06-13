package comp1110.lectures.J12;

import comp1110.lectures.J13.TypeInference;

/**
 * A container that can hold an object of a particular (reference) type.
 * @param <T> type parameter: the type of object that this container can hold
 */
public class GenericHolder<T> {
    static class A {
        @Override
        public String toString() {
            return "This is an A";
        }
    }

    private T value;

    GenericHolder(T value) {
        this.value = value;
    }

    T getValue() {
        return this.value;
    }

    public static  <U> TypeInference.ThingHolder<U> makeHolder(U value) {
        return new TypeInference.ThingHolder(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }

    public static void main(String[] args) {
        GenericHolder<Integer> h = new GenericHolder<>(17);
        System.out.println(h.getValue()+5);
        System.out.println(h);

        GenericHolder<String> s = new GenericHolder<>("Hello");
        System.out.println(s.getValue()+5);
        System.out.println(s);

        A testAtype = new A();
        GenericHolder<A> a = new GenericHolder<>(testAtype); // The parameter can be any java class type
        // as long as it is an reference type ,not a primary type like int, char
        System.out.println(a);

        var anotherHolder = makeHolder(40);
        System.out.println(anotherHolder.toString());
    }
}
