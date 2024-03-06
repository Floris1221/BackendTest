import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.Task2.findPairs;

public class Task2Test {
    @Test
    void testFindAndPrintPairsWithValidInput() {
        String input = "5 8 6 7";
        List<String> expected = List.of("5 8", "6 7");
        Assertions.assertEquals(expected, findPairs(input));
    }

    @Test
    void testFindAndPrintPairsWithNoPairs() {
        String input = "1 2 3";
        List<String> expected = List.of(); // Expecting an empty list
        Assertions.assertEquals(expected, findPairs(input));
    }

    @Test
    void testFindAndPrintPairsWithEmptyInput() {
        String input = "";
        List<String> expected = List.of(); // Expecting an empty list due to no input
        Assertions.assertEquals(expected, findPairs(input));
    }

    @Test
    void testFindAndPrintPairsWithDuplicatesNumber() {
        String input = "6 6 7";
        List<String> expected = List.of("6 7", "6 7");
        Assertions.assertEquals(expected, findPairs(input));
    }

    @Test
    void testFindAndPrintPairsWithDoubleDuplicatesNumber() {
        String input = "6 6 7 7";
        List<String> expected = List.of("6 7", "6 7", "6 7", "6 7");
        Assertions.assertEquals(expected, findPairs(input));
    }

    @Test
    void testFindAndPrintPairsWithTripleDuplicatesNumber() {
        String input = "6 7 7 6 6 7";
        List<String> expected = List.of("6 7", "6 7", "6 7", "6 7", "6 7", "6 7", "6 7", "6 7", "6 7");
        Assertions.assertEquals(expected, findPairs(input));
    }
}
