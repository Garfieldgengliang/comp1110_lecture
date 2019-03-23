package comp1110.lectures.O01;

public class Person {
    private static int age;
    private static String name;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", aged " + age;
    }
}
