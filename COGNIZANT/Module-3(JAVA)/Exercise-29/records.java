import java.util.*;
import java.util.stream.Collectors;
public class records {
    public record Person(String name, int age) {}
        public static void main(String[] args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 30);
        Person p4 = new Person("Diana", 15);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        List<Person> people = List.of(p1, p2, p3, p4);
        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());
        System.out.println("Adults: " + adults);
    }
}
