class NumberPrinter {
    private int number = 1;
    private final int MAX = 10;
    private int state = 1; // 1=Odd, 2=Even, 3=Sum
    private int lastOdd = 0;
    private int lastEven = 0;

    public synchronized void printOdd() throws InterruptedException {
        while (number <= MAX) {
            if (state != 1) {
                wait();
                continue;
            }

            lastOdd = number;
            System.out.println("Odd: " + lastOdd);
            state = 2; // Next: Even
            notifyAll();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (number <= MAX) {
            if (state != 2) {
                wait();
                continue;
            }

            if (number + 1 <= MAX) {
                lastEven = number + 1;
                System.out.println("Even: " + lastEven);
            } else {
                lastEven = 0; // No even left
            }

            state = 3; // Next: Sum
            notifyAll();
        }
    }

    public synchronized void printSum() throws InterruptedException {
        while (number <= MAX) {
            if (state != 3) {
                wait();
                continue;
            }

            int sum = lastOdd + lastEven;
            if (lastEven != 0) {
                System.out.println("Sum: " + sum);
            } else {
                System.out.println("Sum: " + lastOdd);
            }

            number += 2; // Move to next odd
            state = 1;    // Next: Odd
            notifyAll();
        }
    }
}

public class SequentialThreads {
    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();

        Thread t1 = new Thread(() -> {
            try {
                np.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                np.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                np.printSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
