import java.util.*;
import java.util.stream.Collectors;
public class stream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 9, 18, 7, 24, 3);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
    }
}
