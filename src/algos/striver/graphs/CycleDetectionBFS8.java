package algos.striver.graphs;

import java.util.*;


public class CycleDetectionBFS8 {
    static class Pair {
        int node;
        int parentNode;

        Pair(int node, int parent) {
            this.node = node;
            this.parentNode = parent;
        }
    }

    private static boolean detectCycle(List<List<Integer>> adj, int start) {
        int[] visited = new int[adj.size()];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, -1));
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int parent = queue.peek().parentNode;
            queue.poll();
            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == 1 && adjNode != parent) {
                    return true;
                }
                queue.add(new Pair(adjNode, node));
                visited[adjNode] = 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
//        int[][] input = {{}, {2}, {1, 3}, {2}};
        int[][] input = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }
        boolean ans = detectCycle(adj, 0);
        System.out.println("The graph has cycle: " + ans);
    }

}
