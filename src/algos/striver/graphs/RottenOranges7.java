package algos.striver.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges7 {
    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    private static int rottenOranges(int[][] adj) {
        int n = adj.length;
        int[][] visited = new int[n][n];

        Queue<Pair> queue = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else if (adj[i][j] == 0) {
                    visited[i][j] = 0;
                } else {
                    countFresh++;
                }
            }
        }

        int freshCount = 0;
        int minTime = 0;
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            queue.poll();
            int[] drow = {-1, 0, +1, 0};
            int[] dcol = {0, -1, 0, +1};

            for (int i = 0; i < 4; i++) {
                int r = row + drow[i];
                int c = col + dcol[i];

                if (r >= 0 && r < n && c >= 0 && c < n && visited[r][c] != 2 && adj[r][c] == 1) {
                    visited[r][c] = 2;
                    queue.add(new Pair(r, c, time + 1));
                    freshCount++;
                }
            }
            minTime = Math.max(minTime, time);
        }

        if (countFresh != freshCount) return -1;
        return minTime;

    }

    public static void main(String[] args) {
//        int[][] input = {
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 0, 1},
//        };
        int[][] input = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        };

        int minTime = rottenOranges(input);
        System.out.println("Minimum time to rotten: " + minTime);
    }
}
