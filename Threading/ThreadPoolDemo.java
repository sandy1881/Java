import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            System.out.println("Task " + taskId + " was interrupted.");
        }
        System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the pool
        for (int i = 1; i <= 5; i++) {
            executor.submit(new Task(i));
        }

        // Initiate graceful shutdown
        executor.shutdown();
        System.out.println("Executor has been shut down. Waiting for tasks to finish...");

        try {
            // Wait up to 10 seconds for tasks to complete
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Some tasks are still running. Forcing shutdown...");
                executor.shutdownNow(); // Force shutdown
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks finished. Executor terminated.");
    }
}
