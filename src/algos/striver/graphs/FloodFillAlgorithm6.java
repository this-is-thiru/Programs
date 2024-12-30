package algos.striver.graphs;

import java.util.Arrays;

public class FloodFillAlgorithm6 {

    private static void dfs(int[][] adj, int i, int j, int colour) {
        if (i < 0 || i >= adj.length || j < 0 || j >= adj.length || adj[i][j] != colour) {
            return;
        }
        adj[i][j] = colour + 1;

        dfs(adj, i - 1, j, colour);
        dfs(adj, i, j + 1, colour);
        dfs(adj, i + 1, j, colour);
        dfs(adj, i, j - 1, colour);
    }

    private static void floodFillAlgorithm(int[][] adj, int sr, int sc) {
        int n = adj.length;
        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = adj[i][j];
            }
        }

        int colour = visited[sr][sc];
        dfs(visited, sr, sc, colour);

        System.out.println("Count of Islands: ");
        for (int[] arr: visited) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
//        int[][] input = {
//                {1, 1, 0, 0},
//                {1, 1, 0, 0},
//                {0, 0, 0, 0},
//                {1, 1, 0, 1}
//        };

        int[][] input = {
                {1, 1, 1},
                {2, 2, 0},
                {2, 2, 2},
        };

        floodFillAlgorithm(input, 2, 0);
    }
}
