package algos.striver.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands13 {
    static String toString(int a, int b) {
        return a + " " + b;
    }

    private static void dfs(int[][] adj, int i, int j, List<String> arrList, int row0, int col0) {
        if (i < 0 || i >= adj.length || j < 0 || j >= adj[0].length || adj[i][j] == 0) {
            return;
        }
        arrList.add(toString(i - row0, j - col0));
        adj[i][j] = 0;

        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};

        for (int k = 0; k < 4; k++) {
            dfs(adj, i + drow[k], j + dcol[k], arrList, row0, col0);
        }
    }

    private static void numberOfDistinctIslands(int[][] adj) {
        int n = adj.length;
        int m = adj[0].length;

        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (adj[i][j] == 1) {
                    List<String> arrayList = new ArrayList<>();
                    dfs(adj, i, j, arrayList, i, j);
                    set.add(arrayList);
                }
            }
        }

        System.out.println("Count of Distinct Islands: " + set.size());
    }

    public static void main(String[] args) {
//        int[][] input = {
//                {1, 1, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 0, 1, 1},
//                {0, 0, 0, 1, 1}};
        int[][] input = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        numberOfDistinctIslands(input);
    }
}
