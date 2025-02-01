package algos.striver.graphs.disjointset;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    private static boolean isValidPoint(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static List<Integer> getNumberOfIslands(int[][] grid, int n, int m) {
        DisJointSet djs = new DisJointSet(n * m);
        int[][] visited = new int[n][m];
        int count = 0;

        List<Integer> islands = new ArrayList<>();
        for (int[] input : grid) {
            int cRow = input[0];
            int cCol = input[1];

            if (visited[cRow][cCol] == 1) {
                continue;
            }
            visited[cRow][cCol] = 1;
            count++;

            // right -> cRow, cCol + 1
            // down -> cRow + 1, cCol
            // left -> cRow, cCol - 1
            // up -> cRow - 1, cCol
            int[] rows = {0, 1, 0, -1};
            int[] cols = {1, 0, -1, 0};

            for (int j = 0; j < 4; j++) {
                int newRow = cRow + rows[j];
                int newCol = cCol + cols[j];

                if (!isValidPoint(newRow, newCol, n, m)) {
                    continue;
                }

                if (djs.ultimateParent(cRow * m + cCol) == djs.ultimateParent(newRow * m + newCol)) {
                    continue;
                }

                if (visited[newRow][newCol] == 1) {
                    count--;
                    djs.unionBySize(cRow * m + cCol, newRow * m + newCol);
                }
            }
            islands.add(count);
        }

        return islands;
    }

    public static void main(String[] args) {
        // int n = 3, m = 3;
        // int[][] grid = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        int n = 4, m = 5;
        int[][] grid = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};

        List<Integer> islands = getNumberOfIslands(grid, n, m);
        System.out.println(islands);
    }
}
