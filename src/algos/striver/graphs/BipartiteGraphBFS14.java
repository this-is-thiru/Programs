package algos.striver.graphs;

import java.util.*;


public class BipartiteGraphBFS14 {
    static class Pair {
        int node;
        int color;

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    private static boolean isBipartiteGraph(List<List<Integer>> adj, int start) {
        int[] colored = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            colored[i] = -1;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        colored[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int color = queue.peek().color;
            int nextColor = color == 0 ? 1 : 0;
            queue.poll();
            for (int adjNode : adj.get(node)) {
                if (colored[adjNode] == color) {
                    return false;
                } else if (colored[adjNode] != -1) {
                    continue;
                }

                queue.add(new Pair(adjNode, nextColor));
                colored[adjNode] = nextColor;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
//        int[][] input = {{1}, {0,2}, {1}};
        int[][] input = {{2}, {2}, {0, 1}};
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }
        boolean ans = isBipartiteGraph(adj, 0);
        System.out.println("The graph a bipartite graph: " + ans);
    }

}