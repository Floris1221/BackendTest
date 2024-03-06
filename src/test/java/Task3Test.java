import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Task3.countSeparatedGraphs;

public class Task3Test {

    @Test
    void testCountSeparatedGraphsSingleGroup() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}};
        Assertions.assertEquals(1, countSeparatedGraphs(edges));
    }

    @Test
    void testCountSeparatedGraphsMultipleGroups() {
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {7, 8}};
        Assertions.assertEquals(3, countSeparatedGraphs(edges));
    }

    @Test
    void testCountSeparatedGraphsWithDisconnectedVertices() {
        int[][] edges = {{1, 2}, {3, 4}};
        Assertions.assertEquals(2, countSeparatedGraphs(edges));
    }

    @Test
    void testCountSeparatedGraphsNoEdges() {
        int[][] edges = new int[0][0];
        Assertions.assertEquals(0, countSeparatedGraphs(edges));
    }

    @Test
    void testCountSeparatedGraphsComplexCase() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}, {4, 5}, {5, 6}, {6, 4}, {7, 8}, {8, 9}, {9, 7}, {10, 11}};
        Assertions.assertEquals(4, countSeparatedGraphs(edges));
    }
}
