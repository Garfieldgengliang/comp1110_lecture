package comp1110.lectures.J15;

public class testException {
    public  static  double divide(int i, int j){
        if (j == 0){
            throw  new IllegalArgumentException();
        }
        return i/j;
    }
    public static void main(String[] args) {
        try {
            double result = divide(10, 0);
            System.out.println(result);
        }
        catch (IllegalArgumentException e){
            System.out.println("catch the exception");
        }
    }
}
