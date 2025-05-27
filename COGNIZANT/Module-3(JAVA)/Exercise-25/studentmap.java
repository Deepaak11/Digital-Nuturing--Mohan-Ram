import java.util.HashMap;
import java.util.Scanner;
public class studentmap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students do you want to add? ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < count; i++) {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("\nEnter a Student ID to search for name: ");
        int searchId = sc.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }
        sc.close();
    }
}
