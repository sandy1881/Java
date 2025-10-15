package Java8features;


import java.util.*;
import java.util.stream.Collectors;

class StreamGroup {
    private String name;
    private String department;

    public StreamGroup(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

public class StreamGroupDemo{
    public static void main(String[] args) {
        // Create a list of employees
        List<StreamGroup> employees = Arrays.asList(
                new StreamGroup("Sandesh", "IT"),
                new StreamGroup("Ravi", "HR"),
                new StreamGroup("Anita", "IT"),
                new StreamGroup("Divya", "Finance"),
                new StreamGroup("Manoj", "HR"),
                new StreamGroup("Kiran", "Finance"),
                new StreamGroup("Suresh", "IT")
        );

        // Group by department and count employees
        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(StreamGroup::getDepartment, Collectors.counting()));

        // Display the result
        deptCount.forEach((dept, count) ->
                System.out.println(dept + " Department: " + count + " employees"));
    }
}
