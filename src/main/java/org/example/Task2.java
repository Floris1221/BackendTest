package org.example;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        //Input list of Integers
        String inputLine = InputIO.readIntegerList();

        //Process Data
        List<String> pairs = findPairs(inputLine);

        // Results
        pairs.forEach(System.out::println);
    }


    public static List<String> findPairs(String inputLine){
        List<String> pairs = new ArrayList<>();
        if (!inputLine.isEmpty()) {

            //Set sorted List of inputted Integers
            List<Integer> numbers = Arrays.stream(inputLine.split("\\s+"))
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();


            //find and add pairs
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
