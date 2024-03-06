package org.example;

import java.util.Scanner;

public class InputIO {

    private static final Scanner scanner = new Scanner(System.in);

    // Static method to read List of Integer
    public static String readIntegerList(){
        //Instruction
        System.out.println("Enter integers separated by space. Press Enter to finish:");
        try (scanner){
            return scanner.nextLine();

        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return "";
        }
    }

    // Static method to safely read an integer
    public static int readInt(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("This is not a number! Please, try again:");
            scanner.next(); // Clears incorrect input
        }
        return Integer.parseInt(scanner.nextLine().trim());
    }

    // Static method to read edges from the user input
    public static int[][] readEdges(int numberOfEdges) {
        int[][] edges = new int[numberOfEdges][2];
        int i = 0;
        while (i < numberOfEdges) {
            System.out.println("Enter both vertices for edge " + (i + 1) + ", separated by a space:");
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 2) {
                try {
                    edges[i][0] = Integer.parseInt(parts[0]);
                    edges[i][1] = Integer.parseInt(parts[1]);
                    i++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter two integers separated by a space.");
                }
            } else {
                System.out.println("Invalid input. Please enter exactly two numbers separated by a space.");
            }
        }
        return edges;
    }

    // Static method to close the scanner (if necessary)
    public static void close() {
        scanner.close();
    }
}
