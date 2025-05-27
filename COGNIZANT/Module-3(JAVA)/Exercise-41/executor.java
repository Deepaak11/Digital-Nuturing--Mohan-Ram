import java.util.concurrent.*;
import java.util.*;
public class executor {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
            () -> "Task 1 result",
            () -> "Task 2 result",
            () -> "Task 3 result"
        );
        List<Future<String>> futures = new ArrayList<>();
        for (Callable<String> task : tasks) {
            futures.add(executor.submit(task));
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());  
        }
        executor.shutdown();
    }
}
