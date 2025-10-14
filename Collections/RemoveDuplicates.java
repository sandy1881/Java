import java.util.ArrayList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);
        list.add(10);

        System.out.println("Before removing duplicates: " + list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--; 
                }
            }
        }

        System.out.println("After removing duplicates: " + list);
    }
}


// Remove Duplicates in O(n log n) using sorting and single pass

// import java.util.ArrayList;
// import java.util.Collections;

// public class RemoveDuplicatesOptimized {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(10);
//         list.add(30);
//         list.add(20);
//         list.add(40);
//         list.add(10);

//         System.out.println("Before removing duplicates: " + list);

//         //Sort the list
//         Collections.sort(list);

//         //Remove duplicates in one pass
//         for (int i = 0; i < list.size() - 1; i++) {
//             if (list.get(i).equals(list.get(i + 1))) {
//                 list.remove(i + 1);
//                 i--; 
//             }
//         }

//         System.out.println("After removing duplicates: " + list);
//     }
// }
