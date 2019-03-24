package comp1110.lectures.O05;

public class EqualsHashCode {
    public static class Person {
        String name;
        int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Person) {
                Person other = (Person)obj;
                return this.name.equals(other.name) && this.age == other.age;// in this line, this.name.equal
                // is just to check whether this.name is the same as other.name, because name is a field, not an instance
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return name.hashCode() ^ age;
        }
    }

    public static void main(String[] args) {
        Person priyanka = new Person("Priyanka", 20);
        Person tutorWed09b = new Person("Priyanka", 20);
        System.out.println(priyanka == tutorWed09b);
        System.out.println(priyanka.equals(tutorWed09b));
    }

}
