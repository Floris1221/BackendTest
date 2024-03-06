package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    static class UnionFind {

        private Map<Integer, Integer> parent = new HashMap<>();

        public int find(int x) {
            if (!parent.containsKey(x)) parent.put(x, x);
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootY, rootX);
            }
        }
    }

    public static int countSeparatedGraphs(int[][] edges) {
        UnionFind uf = new UnionFind();
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return (int) uf.parent.keySet().stream().filter(key -> uf.find(key) == key).count();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("This is not a number! Enter edge:");
            scanner.next(); // Czyści błędne dane wejściowe
        }
        int n = scanner.nextInt();
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.println("This is not a number! Re-enter the first vertex:");
                    scanner.next(); // Czyści błędne dane wejściowe
                    continue;
                }
                edges[i][0] = scanner.nextInt();

                if (!scanner.hasNextInt()) {
                    System.out.println("This is not a number! Re-enter the second vertex:");
                    scanner.next(); // Czyści błędne dane wejściowe
                    continue;
                }
                edges[i][1] = scanner.nextInt();
                break;
            }
        }
        scanner.close();

        System.out.println(countSeparatedGraphs(edges));
    }
}
