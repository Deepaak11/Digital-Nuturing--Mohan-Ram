public class virtualthreads {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100_000];
        for (int i = 0; i < 100_000; i++) {
            threads[i] = Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread"));
        }
        for (Thread t : threads) t.join();
    }
}
