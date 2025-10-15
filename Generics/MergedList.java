package Generics;
import java.util.*;

class ListUtils {
    // Generic method to merge two lists and remove duplicates
    public static <T> List<T> mergeAndRemoveDuplicates(List<T> list1, List<T> list2) {
        // Use LinkedHashSet to maintain order and remove duplicates
        Set<T> mergedSet = new LinkedHashSet<>();

        mergedSet.addAll(list1);
        mergedSet.addAll(list2);

        return new ArrayList<>(mergedSet);
    }
}

public class MergedList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        List<Integer> mergedList = ListUtils.mergeAndRemoveDuplicates(list1, list2);
        System.out.println("Merged Integer List: " + mergedList);

        List<String> strList1 = Arrays.asList("Apple", "Banana", "Mango");
        List<String> strList2 = Arrays.asList("Banana", "Cherry", "Mango");

        List<String> mergedStrList = ListUtils.mergeAndRemoveDuplicates(strList1, strList2);
        System.out.println("Merged String List: " + mergedStrList);
    }
}
