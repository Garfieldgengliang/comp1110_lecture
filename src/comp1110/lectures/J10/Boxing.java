package comp1110.lectures.J10;

public class Boxing {
    public static void main(String[] args) {
        Integer a = new Integer(6);
        Integer b = 6;

        Object z = a;
        Integer y = (Integer)(z);

        int c = a; // automatically unboxing
        int d = new Integer(6); // automatically unboxing

        if (a == b) {
            System.out.println("a("+a+") == b("+b+")");
        } else {
            System.out.println("a("+a+") != b("+b+")"); // because a and b are different objects
        }

        if (a.equals(b)) {
            System.out.println("a("+a+") equals b("+b+")"); // because the value of a equals the value of b
        } else {
            System.out.println("a("+a+") does not equal b("+b+")");
        }

        if (a == c) { // automatically unboxing
            System.out.println("a("+a+") == c("+c+")");
        } else {
            System.out.println("a("+a+") != c("+c+")");
        }

        if (a.equals(c)) { //automatically boxing c
            System.out.println("a("+a+") equals c("+c+")");
        } else {
            System.out.println("a("+a+") does not equal c("+c+")");
        }
    }
}
