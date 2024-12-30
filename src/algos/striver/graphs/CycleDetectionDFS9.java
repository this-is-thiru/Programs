package algos.striver.graphs;

import java.util.*;


public class CycleDetectionDFS9 {
    static class Pair {
        int node;
        int parentNode;

        Pair(int node, int parent) {
            this.node = node;
            this.parentNode = parent;
        }
    }

    private static boolean detectCycle(List<List<Integer>> adj, Pair ele, int[] visited) {
        int node = ele.node;
        int parent = ele.parentNode;

        for (int adjNode: adj.get(node)) {
            if (visited[adjNode] == 1 && adjNode != parent) {
                return true;
            }
            if (adjNode == parent) {
                continue;
            }
            visited[adjNode] = 1;
            boolean isCycle = detectCycle(adj, new Pair(adjNode, node), visited);
            if (isCycle) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] input = {{}, {2}, {1, 3}, {2}};
        int[][] input = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};

        List<List<Integer>> adj = new ArrayList<>();
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }

        int start = 0;
        int[] visited = new int[adj.size()];
        visited[start] = 1;
        boolean ans = false;
        for (int i = 0; i < visited.length; i++) {
            ans = ans || detectCycle(adj, new Pair(i, -1), visited);
        }
        System.out.println("The graph has cycle: " + ans);
    }

}
