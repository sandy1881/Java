package Java8features;
import java.util.*;
import java.util.stream.*;
 
public class ParallelStream {
    public static void main(String[] args) {
        // Create a large list of integers (1 to 10,000,000)
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());

        // Sequential Stream
        long startTime = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
                                    .mapToLong(Integer::longValue)
                                    .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Sum: " + sequentialSum);
        System.out.println("Sequential Time: " + (endTime - startTime) + " ms");

        // Parallel Stream
        startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
                                  .mapToLong(Integer::longValue)
                                  .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Sum: " + parallelSum);
        System.out.println("Parallel Time: " + (endTime - startTime) + " ms");
    }
}
