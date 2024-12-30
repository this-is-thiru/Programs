package algos.striver.graphs;

import java.util.*;

public class DFSTraversal3 {
    private static void dfs(List<List<Integer>> adj, int node, int[] visited, List<Integer> dfs) {
        if (visited[node] == 1) {
            return;
        }
        dfs.add(node);
        visited[node] = 1;

        List<Integer> adjNodes = adj.get(node);
        for (int adjNode : adjNodes) {
            dfs(adj, adjNode, visited, dfs);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
//        int[][] input = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        int[][] input = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }
        // Because this is zero bases indexing else it could be adj.size()+1
        int[] visited = new int[input.length];
        List<Integer> dfs = new ArrayList<>();

        dfs(adj, 0, visited, dfs);
        System.out.println(dfs);
    }
    
}
