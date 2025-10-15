package Generics;

class AverageCalculator<T extends Number> {
    private T[] numbers;

    public AverageCalculator(T[] numbers) {
        this.numbers = numbers;
    }

    // Method to compute average
    public double calculateAverage() {
        double sum = 0.0;
        for (T num : numbers) {
            sum += num.doubleValue(); // Convert each Number to double
        }
        return sum / numbers.length;
    }
}

public class AverageGeneric {
    public static void main(String[] args) {
        // Integer example
        Integer[] intArr = {1, 2, 3, 4, 5};
        AverageCalculator<Integer> intCalc = new AverageCalculator<>(intArr);
        System.out.println("Average of Integers: " + intCalc.calculateAverage());

        // Double example
        Double[] doubleArr = {2.5, 3.5, 4.5, 5.5};
        AverageCalculator<Double> doubleCalc = new AverageCalculator<>(doubleArr);
        System.out.println("Average of Doubles: " + doubleCalc.calculateAverage());

        // Float example
        Float[] floatArr = {1.2f, 3.4f, 5.6f};
        AverageCalculator<Float> floatCalc = new AverageCalculator<>(floatArr);
        System.out.println("Average of Floats: " + floatCalc.calculateAverage());
    }
}
