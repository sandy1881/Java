package Java8features;

import java.io.File;
import java.util.function.Predicate;

public class FileFilter {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\sandeshkumar.hr\\OneDrive - VCTI\\Documents"); // 🔹 Change this path as needed

        // Predicate to filter only .txt files
        Predicate<File> txtFileFilter = file -> file.isFile() && file.getName().endsWith(".txt");

        // Predicate to filter files larger than 1KB
        Predicate<File> largeFileFilter = file -> file.isFile() && file.length() > 1024;

        // Combine multiple predicates (AND condition)
        Predicate<File> combinedFilter = txtFileFilter.and(largeFileFilter);

        // List files in directory and apply filter
        File[] filteredFiles = folder.listFiles(file -> combinedFilter.test(file));

        if (filteredFiles != null && filteredFiles.length > 0) {
            System.out.println("Filtered Files:");
            for (File file : filteredFiles) {
                System.out.println(file.getName() + " (" + file.length() + " bytes)");
            }
        } else {
            System.out.println("No files matched the filter.");
        }
    }
}
