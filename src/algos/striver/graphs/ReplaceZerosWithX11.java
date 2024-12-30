package algos.striver.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ReplaceZerosWithX11 {
    private static void dfs(char[][] arr, int[][] visited, int row, int col, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m || arr[row][col] == 'X' || visited[row][col] == 1) {
            return;
        }
        visited[row][col] = 1;
        dfs(arr, visited, row + 1, col, n, m);
        dfs(arr, visited, row - 1, col, n, m);
        dfs(arr, visited, row, col + 1, n, m);
        dfs(arr, visited, row, col - 1, n, m);
    }

    static char[][] fill(int n, int m, char[][] a) {
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            dfs(a, visited, i, 0, n, m);
            dfs(a, visited, i, m - 1, n, m);
        }
        for (int i = 0; i < m; i++) {
            dfs(a, visited, 0, i, n, m);
            dfs(a, visited, n - 1, i, n, m);
        }

        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 1) {
                    ans[i][j] = '0';
                } else {
                    ans[i][j] = 'X';
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
//        char[][] input = {
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//                {'X', 'X', 'O', 'O'}};

        char[][] ansMatrix = fill(input.length, input[0].length, input);

        System.out.println("Matrix after replacing 0's with X: ");
        for (char[] row : ansMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
