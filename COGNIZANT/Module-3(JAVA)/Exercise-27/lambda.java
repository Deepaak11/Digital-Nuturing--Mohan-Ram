import java.util.*;
public class lambda {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");
        Collections.sort(fruits, (a, b) -> a.compareTo(b));
        System.out.println("Sorted list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
