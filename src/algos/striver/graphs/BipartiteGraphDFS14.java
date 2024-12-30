package algos.striver.graphs;

import java.util.*;


public class BipartiteGraphDFS14 {
    private static boolean dfs(List<List<Integer>> adj, int node, int color, int[] colored) {
        if (colored[node] != -1 && colored[node] != color) {
            return false;
        }

        if (colored[node] == color) {
            return true;
        }

        colored[node] = color;
        for (Integer adjNode: adj.get(node)) {
            int nextColor = color == 0 ? 1 : 0;
            if(adjNode == node) {
                continue;
            }
            if (!dfs(adj, adjNode, nextColor, colored)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isBipartiteGraph(List<List<Integer>> adj, int start) {
        int[] colored = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            colored[i] = -1;
        }
        return dfs(adj, start, 0, colored);
    }


    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int[][] input = {{1}, {0,2}, {1}};
//        int[][] input = {{2}, {2}, {0, 1}};
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }
        boolean ans = isBipartiteGraph(adj, 0);
        System.out.println("The graph a bipartite graph: " + ans);
    }

}