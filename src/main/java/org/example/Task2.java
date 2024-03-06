package org.example;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        //Instruction
        System.out.println("Enter integers separated by space. Press Enter to finish:");

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();

            //GetData from input
            //List<String> uniquePairs =
            List<String> pairs = findAndPrintPairs(line);

            // Results
            pairs.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


    public static List<String> findAndPrintPairs(String line){
        List<String> pairs = new ArrayList<>();
        if (!line.isEmpty()) {

            List<Integer> numbers = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();



            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (numbers.get(i) + numbers.get(j) == 13) {
                        String pair = numbers.get(i) + " " + numbers.get(j);
                        pairs.add(pair);

                    }
                }
            }
        } else {
            System.out.println("No input provided.");
        }
        return pairs;
    }

}
