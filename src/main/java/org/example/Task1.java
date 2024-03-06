package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class Task1 {



    public static void main(String[] args) {

        //Instruction
        System.out.println("Enter integers separated by space. Press Enter to finish:");

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();

            //GetData from input
            ResultData resultData = processInput(line);

            // Results
            System.out.print("Sorted distinct elements: ");
            resultData.distinctSorted.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
            System.out.println("Total count (including duplicates and invalid inputs): " + resultData.totalCount);
            System.out.println("Distinct count: " + resultData.distinctSorted.size());
            if (!resultData.distinctSorted.isEmpty()) {
                System.out.println("Min: " + resultData.distinctSorted.first());
                System.out.println("Max: " + resultData.distinctSorted.last());
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


    public static ResultData processInput(String line){

        if (!line.isEmpty()) {
            ConcurrentSkipListSet<Integer> distinctSorted = new ConcurrentSkipListSet<>();
            long totalCount = 0;

            //Set array of inputs
            String[] inputs = line.split("\\s+");
            totalCount = inputs.length;


            //Add parallel do distinctSorted and skipp invalid value
            Stream.of(inputs).parallel().forEach(input -> {
                try {
                    int number = Integer.parseInt(input);
                    distinctSorted.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input skipped: " + input);
                }
            });

            return new ResultData(distinctSorted, totalCount);

        } else {
            System.out.println("No input provided.");
            return new ResultData(new ConcurrentSkipListSet<>(), 0);
        }
    }


    public static class ResultData {
        public final  ConcurrentSkipListSet<Integer> distinctSorted;
        public final long totalCount;

        public ResultData( ConcurrentSkipListSet<Integer> distinctSorted, long totalCount) {
            this.distinctSorted = distinctSorted;
            this.totalCount = totalCount;
        }
    }
}