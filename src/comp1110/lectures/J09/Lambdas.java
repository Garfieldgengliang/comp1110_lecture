package comp1110.lectures.J09;

import java.util.function.IntPredicate;

public class Lambdas {

    // lumbda expression ususally implements in functional interface,
    // which has only one method, in this method, it takes several parameter and returns a certain type of data
    // when assign a lumbda expression to this interface, the left part of -> is the required parameter and the right part of ->
    // is the required return

    public static  void arrayDetect(int[] a, IntPredicate predicate){
        for(int i = 0; i < a.length; i++){
            int current = a[i];
            if(predicate.test(current)){
                System.out.println(current);
            }
        }
    }

    public static void main(String[] args) {
        int[] testarray = new int[40];
        for(int index = 0; index<testarray.length; index++){
            testarray[index] = index*2;
        }

        arrayDetect(testarray, x -> x%2==0);
        System.out.println();

        arrayDetect(testarray, x -> {
            double sqrtx = Math.sqrt(x);
            return sqrtx == Math.round(sqrtx);

        });

    }

}
/*
static void printMultiplesOf(int divisor, int[] a) {
        System.out.println("Printing multiples of " + divisor);
        for (int i = 0; i < a.length; i++) {
            if (a[i] % divisor == 0) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    static void printMatching(int[] a, IntPredicate predicate) {
        for (int i = 0; i < a.length; i++) {
            if (predicate.test(a[i])) {
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[42];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        //printMultiplesOf(2, a);
        //printMultiplesOf(3, a);
        System.out.println("Even numbers");
        printMatching(a, x -> x % 2 == 0);
        System.out.println();

        System.out.println("Multiples of three");
        printMatching(a, x -> {return x % 3 == 0;} );
        System.out.println();

        System.out.println("Squares");
        printMatching(a, x -> {
            double sqrtX = Math.sqrt((double)x);
            return Math.round(sqrtX) == sqrtX;
        }
        );


    }
 */