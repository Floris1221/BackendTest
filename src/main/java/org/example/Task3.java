package org.example;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    public static void main(String[] args) {

        // Read the number of edges from the user input
        int numberOfEdges = InputIO.readInt("Enter the number of edges:");

        // Read the edges
        int[][] edges = InputIO.readEdges(numberOfEdges);

        // Calculate and print the number of separate graphs formed by these edges
        System.out.println(countSeparatedGraphs(edges));

        InputIO.close();
    }

    public static int countSeparatedGraphs(int[][] edges) {
        UnionFind unionFind = new UnionFind();

        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return (int) unionFind.parent.keySet().stream().filter(key -> unionFind.find(key) == key).count();
    }



    static class UnionFind {

        private Map<Integer, Integer> parent = new HashMap<>();

        // Finds the representative of the set to which 'x' belongs and compresses the path along the way.
        public int find(int edge) {
            if (!parent.containsKey(edge)) parent.put(edge, edge);
            if (edge != parent.get(edge)) {
                parent.put(edge, find(parent.get(edge)));
            }
            return parent.get(edge);
        }

        // Unites the sets containing 'x' and 'y' by setting their representatives to be the same.
        public void union(int edgeX, int edgeY) {
            int rootX = find(edgeX);
            int rootY = find(edgeY);
            if (rootX != rootY) {
                parent.put(rootY, rootX);
            }
        }
    }
}
