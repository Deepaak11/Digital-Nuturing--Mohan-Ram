public class typecasting {
    public static void main(String[] args) {
        double a = 9.78;
        int b = (int) a;  
        int c = 42;
        double d = (double) c; 
        System.out.println("Original double value: " + a);
        System.out.println("After casting double to int: " + b);
        System.out.println("Original int value: " + c);
        System.out.println("After casting int to double: " + d);
    }
}
