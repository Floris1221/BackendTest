package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

//package org.example;
//
//        import java.util.*;
//        import java.util.concurrent.ConcurrentSkipListSet;
//        import java.util.stream.Stream;
//
//public class Task1 {
//
//
//
//
//
//    public static void main(String[] args) {
//
//        System.out.println("Enter integers separated by space. Press Enter to finish:");
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            String line = scanner.nextLine();
//            ResultData resultData = processInput(line);
//
//            // Results
//            System.out.print("Sorted distinct elements: ");
//            resultData.distinctSorted.forEach(integer -> System.out.print(integer + " "));
//            System.out.println();
//            System.out.println("Total count (including duplicates and invalid inputs): " + resultData.totalCount);
//            System.out.println("Distinct count: " + resultData.distinctSorted.size());
//            if (!resultData.distinctSorted.isEmpty()) {
//                System.out.println("Min: " + resultData.distinctSorted.first());
//                System.out.println("Max: " + resultData.distinctSorted.last());
//            }
//
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//    }
//
//
//    public static ResultData processInput(String line){
//        if (!line.isEmpty()) {
//            ConcurrentSkipListSet<Integer> distinctSorted = new ConcurrentSkipListSet<>();
//            long count = 0;
//
//            String[] inputs = line.split("\\s+");
//            count = inputs.length;
//
//
//            Stream.of(inputs).parallel().forEach(input -> {
//                try {
//                    int number = Integer.parseInt(input);
//                    distinctSorted.add(number);
//                } catch (NumberFormatException e) {
//                    System.err.println("Invalid input skipped: " + input);
//                }
//            });
//
//        } else {
//            System.out.println("No input provided.");
//        }
//    }
//
//
//    public static class ResultData {
//        public final Set<Integer> distinctSorted;
//        public final long totalCount;
//
//        public ResultData(Set<Integer> distinctSorted, long totalCount) {
//            this.distinctSorted = distinctSorted;
//            this.totalCount = totalCount;
//        }
//    }
//}
//
//
//
//--------------
//        package org.example;
//
//        import java.util.*;
//        import java.util.concurrent.ConcurrentSkipListSet;
//        import java.util.stream.Stream;
//
//public class Task1 {
//
//



//    public static void main(String[] args) {
//
//        System.out.println("Enter integers separated by space. Press Enter to finish:");
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            String line = scanner.nextLine();
//
//            if (!line.isEmpty()) {
//                ConcurrentSkipListSet<Integer> distinctSorted = new ConcurrentSkipListSet<>();
//                long count = 0;
//
//                String[] inputs = line.split("\\s+");
//                count = inputs.length;
//
//
//                Stream.of(inputs).parallel().forEach(input -> {
//                    try {
//                        int number = Integer.parseInt(input);
//                        distinctSorted.add(number);
//                    } catch (NumberFormatException e) {
//                        System.err.println("Invalid input skipped: " + input);
//                    }
//                });
//
//                // Wyniki
//                System.out.print("Sorted distinct elements: ");
//                distinctSorted.forEach(integer -> System.out.print(integer + " "));
//                System.out.println();
//                System.out.println("Total count (including duplicates and invalid inputs): " + count);
//                System.out.println("Distinct count: " + distinctSorted.size());
//                if (!distinctSorted.isEmpty()) {
//                    System.out.println("Min: " + distinctSorted.first());
//                    System.out.println("Max: " + distinctSorted.last());
//                }
//            } else {
//                System.out.println("No input provided.");
//            }
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//    }
//}
//
