import java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class customexception {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older.");
            } else {
                System.out.println("You are eligible!");
            }
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
