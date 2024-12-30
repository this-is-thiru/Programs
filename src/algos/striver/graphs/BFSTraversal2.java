package algos.striver.graphs;

import java.util.*;

public class BFSTraversal2 {
    private static void bfs(List<List<Integer>> adj, int start) {
        // Because this is zero bases indexing else it could be adj.size()+1
        int[] visited = new int[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        List<Integer> bfsTraversal = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node] == 1) {
                continue;
            }
            visited[node] = 1;
            bfsTraversal.add(node);
            List<Integer> connectedNodes = adj.get(node);
            for (int connectedNode : connectedNodes) {
                queue.add(connectedNode);
            }
        }

        System.out.println("BFS of Graph: " + bfsTraversal);
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
//        int[][] input = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        int[][] input = {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }
        bfs(adj, 0);
    }
}
