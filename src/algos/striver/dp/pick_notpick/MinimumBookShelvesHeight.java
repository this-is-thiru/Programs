package algos.striver.dp.pick_notpick;

import java.util.Arrays;

public class MinimumBookShelvesHeight {
    private int WIDTH;
    private int n;

    private int minimumHeight(int index, int[][] books, int remainingWidth, int maxHeightCurrentShelf) {
        if (index >= n) {
            return maxHeightCurrentShelf;
        }

        int bookWidth = books[index][0];
        int bookHeight = books[index][1];

        int considerToCurrent = Integer.MAX_VALUE;
        if (bookWidth <= remainingWidth) {
            considerToCurrent = minimumHeight(index + 1, books, remainingWidth - bookWidth, Math.max(maxHeightCurrentShelf, bookHeight));
        }
        int notConsiderToCurrent = maxHeightCurrentShelf+minimumHeight(index + 1, books, WIDTH-bookWidth,  bookHeight);

        return Math.min(considerToCurrent, notConsiderToCurrent);
    }

    private int memoization(int index, int[][] books, int remainingWidth, int maxHeightCurrentShelf, int[][] dp) {
        if (index >= n) {
            return maxHeightCurrentShelf;
        }

        if (dp[index][remainingWidth] != -1) {
            return dp[index][remainingWidth];
        }

        int bookWidth = books[index][0];
        int bookHeight = books[index][1];

        int considerToCurrent = Integer.MAX_VALUE;
        if (bookWidth <= remainingWidth) {
            considerToCurrent = memoization(index + 1, books, remainingWidth - bookWidth, Math.max(maxHeightCurrentShelf, bookHeight), dp);
        }
        int notConsiderToCurrent = maxHeightCurrentShelf+memoization(index + 1, books, WIDTH-bookWidth,  bookHeight, dp);

        return dp[index][remainingWidth] = Math.min(considerToCurrent, notConsiderToCurrent);
    }

    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int selfWidth = 4;

        MinimumBookShelvesHeight minimumBookShelvesHeight = new MinimumBookShelvesHeight();
        minimumBookShelvesHeight.WIDTH = selfWidth;
        minimumBookShelvesHeight.n = books.length;

        int minimumHeight = minimumBookShelvesHeight.minimumHeight(0, books, selfWidth, 0);
        System.out.println("Minimum Height to keep all books: " + minimumHeight);

        int[][] dp = new int[books.length][selfWidth + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int memoization = minimumBookShelvesHeight.memoization(0, books, selfWidth, 0, dp);
        System.out.println("Minimum Height to keep all books {Memoization}: " + memoization);

    }
}
