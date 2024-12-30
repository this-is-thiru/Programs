package algos.striver.graphs;

import java.util.*;


public class Nearest1ToElement10 {
    static class Pair {
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private static int[][] bfs(int[][] visited, int[][] distance, Queue<Pair> queue, int m, int n) {
        while (!queue.isEmpty()) {
            Pair ele = queue.poll();
            int row = ele.row;
            int col = ele.col;
            int dis = ele.distance;

            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int adjRow = row + drow[i];
                int adjCol = col + dcol[i];
                if (adjRow >= 0 && adjRow < m && adjCol >= 0 && adjCol < n && visited[adjRow][adjCol] != 1) {
                    visited[adjRow][adjCol] =1;
                    distance[adjRow][adjCol] = dis+1;
                    queue.add(new Pair(adjRow, adjCol, dis+1));
                }
            }
        }
        return distance;
    }

    private static int[][] nearestOneMatrix(int[][] adj, int m, int n) {
        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == 1) {
                    visited[i][j] = 1;
                    distance[i][j] = 0;
                    queue.add(new Pair(i, j, 0));
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        return bfs(visited, distance, queue, m, n);
    }

    public static void main(String[] args) {
//        int[][] input = {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        int[][] input = {{1,0,1},{1,1,0},{1,0,0}};

        int[][] ansMatrix = nearestOneMatrix(input, input.length, input[0].length);

        System.out.println("Nearest one matrix: ");
        for (int[] row : ansMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
