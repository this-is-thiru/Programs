package algos.fifty.arraysandhash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    private static boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    String str = "(" + board[i][j] + ")";
                    if (!set.add("i" + i + str) || !set.add("j" + j + str) || !set.add("ij" + i / 3 + str + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean isValidSudoku = isValidSudoku(board);
        System.out.println(isValidSudoku);
    }
}
