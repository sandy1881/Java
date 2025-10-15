package Java8features;

@FunctionalInterface
interface StringOperation {
    String operate(String str);
}


public class CustomFunctionalInterface {
    public static void main(String[] args) {
        // Lambda 1: Convert to Uppercase
        StringOperation toUpper = s -> s.toUpperCase();

        // Lambda 2: Reverse a String
        StringOperation reverse = s -> new StringBuilder(s).reverse().toString();

        // Lambda 3: Add Prefix
        StringOperation addPrefix = s -> "Hello, " + s;

        // Test the implementations
        System.out.println(toUpper.operate("sandesh"));   // SANDESH
        System.out.println(reverse.operate("Lambda"));    // adbmaL
        System.out.println(addPrefix.operate("Kumar"));   // Hello, Kumar
    }
}

