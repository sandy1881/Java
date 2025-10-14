import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
    private final CountDownLatch latch;
    private final int workerId;

    public Worker(CountDownLatch latch, int workerId) {
        this.latch = latch;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker " + workerId + " started.");
            Thread.sleep((long)(Math.random() * 2000)); // simulate work
            System.out.println("Worker " + workerId + " finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // signal completion
        }
    }
}

public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numWorkers = 5;
        CountDownLatch latch = new CountDownLatch(numWorkers);

        // Start worker threads
        for (int i = 1; i <= numWorkers; i++) {
            new Thread(new Worker(latch, i)).start();
        }

        System.out.println("Main thread is waiting for workers to finish...");

        // Wait for all workers to finish
        latch.await();

        System.out.println("All workers finished. Main thread proceeds.");
    }
}
