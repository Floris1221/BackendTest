package org.example;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    public static void main(String[] args) {

        // Read the number of edges from the user input
        int n = InputIO.readInt("Enter the number of edges:");

        // Read the edges
        int[][] edges = InputIO.readEdges(n);

        // Calculate and print the number of separate graphs formed by these edges
        System.out.println(countSeparatedGraphs(edges));

        InputIO.close();
    }

    public static int countSeparatedGraphs(int[][] edges) {
        UnionFind uf = new UnionFind();

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return (int) uf.parent.keySet().stream().filter(key -> uf.find(key) == key).count();
    }



    static class UnionFind {

        private Map<Integer, Integer> parent = new HashMap<>();

        // Finds the representative of the set to which 'x' belongs and compresses the path along the way.
        public int find(int x) {
            if (!parent.containsKey(x)) parent.put(x, x);
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        // Unites the sets containing 'x' and 'y' by setting their representatives to be the same.
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootY, rootX);
            }
        }
    }
}
