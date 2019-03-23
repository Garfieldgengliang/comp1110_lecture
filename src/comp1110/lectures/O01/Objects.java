package comp1110.lectures.O01;

public class Objects {
    public static void main(String[] args) {
        Person mary = new Person("Mary", 22);
        // combine declaration(Person Mary, which means mary is a Person type), instanciation(new)
        // and initialization(using constructior, Person).
        Person fred = new Person("Fred", 20);
        System.out.println("What I know about mary: " + mary);
        System.out.println("What I know about fred: " + fred.toString());
    }
}
