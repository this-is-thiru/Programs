package algos.striver.graphs;

public class NumberOfIslands5 {

    private static void dfs(int[][] adj, int i, int j) {
        if (i < 0 || i >= adj.length || j < 0 || j >= adj.length || adj[i][j] == 0) {
            return;
        }
        adj[i][j] = 0;

        int[] drow = {-1, -1, 0, 1, 1, 1, -1, 0};
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int k = 0; k < 8; k++) {
            dfs(adj, i+drow[k], j+dcol[k]);
        }
    }

    private static void numberOfIslands(int[][] adj) {
        int n = adj.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == 1) {
                    dfs(adj, i, j);
                    count++;
                }
            }
        }

        System.out.println("Count of Islands: " + count);
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };

        numberOfIslands(input);
    }
}
