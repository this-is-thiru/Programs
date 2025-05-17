package recursion;

import java.util.Arrays;

public class NQueen {
    private static void solve(int[][] board, int col, int n) {
        if (col >= n) {
            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("-----------------------------------");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(board, col, i, n)) {
                board[i][col] = 1;
                solve(board, col + 1, n);
                board[i][col] = 0;
            }
        }
    }

    private static boolean canPlace(int[][] board, int col, int row, int n) {
        // left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // down diagonal
        int tempCol = col;
        int tempRow = row;
        while (tempRow >= 0 && tempCol >= 0) {
            if (board[tempRow][tempCol] == 1) {
                return false;
            }
            tempRow--;
            tempCol--;
        }

        // down diagonal
        tempCol = col;
        tempRow = row;
        while (tempRow <= n - 1 && tempCol >= 0) {
            if (board[tempRow][tempCol] == 1) {
                return false;
            }
            tempRow++;
            tempCol--;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        solve(board, 0, n);
    }
}
