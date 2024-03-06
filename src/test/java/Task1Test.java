import org.example.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Task1Test {

    @Test
    void testProcessInputWithValidNumbers() {
        String input = "1 2 3 4 5 1 2 3";
        Task1.ResultData result = Task1.processInput(input);

        Assertions.assertEquals(8, result.totalCount);
        Assertions.assertEquals(5, result.distinctSorted.size());
        assertTrue(result.distinctSorted.containsAll(Set.of(1, 2, 3, 4, 5)));
    }

    @Test
    void testProcessInputWithInvalidNumbers() {
        String input = "1 a 3 b c 5 6";
        Task1.ResultData result = Task1.processInput(input);

        Assertions.assertEquals(7, result.totalCount);
        Assertions.assertEquals(4, result.distinctSorted.size());
        assertTrue(result.distinctSorted.containsAll(Set.of(1, 3, 5, 6)));
    }

    @Test
    void testProcessInputEmpty() {
        String input = "";
        Task1.ResultData result = Task1.processInput(input);

        Assertions.assertEquals(0, result.totalCount);
        assertTrue(result.distinctSorted.isEmpty());
    }

    @Test
    void testProcessInputOnlyZeros() {
        String input = "0 0 0 0 0 0 0 0";
        Task1.ResultData result = Task1.processInput(input);

        Assertions.assertEquals(8, result.totalCount);
        Assertions.assertEquals(1, result.distinctSorted.size());
        assertTrue(result.distinctSorted.contains(0));
    }
}
