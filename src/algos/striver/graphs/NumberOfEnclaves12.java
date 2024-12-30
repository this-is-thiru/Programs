package algos.striver.graphs;


public class NumberOfEnclaves12 {
    private static void dfs(int[][] arr, int[][] visited, int row, int col, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m || arr[row][col] == 0 || visited[row][col] == 1) {
            return;
        }
        visited[row][col] = 1;
        dfs(arr, visited, row + 1, col, n, m);
        dfs(arr, visited, row - 1, col, n, m);
        dfs(arr, visited, row, col + 1, n, m);
        dfs(arr, visited, row, col - 1, n, m);
    }

    static int numberOfEnclaves(int n, int m, int[][] a) {
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            dfs(a, visited, i, 0, n, m);
            dfs(a, visited, i, m - 1, n, m);
        }
        for (int i = 0; i < m; i++) {
            dfs(a, visited, 0, i, n, m);
            dfs(a, visited, n - 1, i, n, m);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && visited[i][j] != 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[][] input = {
//                {0, 0, 0, 0},
//                {1, 0, 1, 0},
//                {0, 1, 1, 0},
//                {0, 0, 0, 0}};
        int[][] input = {
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}};

        int numberOfEnclaves = numberOfEnclaves(input.length, input[0].length, input);

        System.out.println("Number of enclaves: " + numberOfEnclaves);
    }
}
