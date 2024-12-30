package algos.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CycleDetectionDirectedGraphDFS15 {
    private static boolean detectCycle(List<List<Integer>> adj, int node, int[] visited, int[] pathVisited) {
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                visited[adjNode] = 1;
                pathVisited[adjNode] = 1;
                if (detectCycle(adj, adjNode, visited, pathVisited)){
                    return true;
                }
                pathVisited[adjNode] = 0;
            } else if (pathVisited[adjNode] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] input = {{1, 2}, {3}, {}, {}, {1, 5}, {3}}; // no
//        int[][] input = {{1,2}, {2}, {0, 3}, {3}}; // yes
//        int[][] input = {{1}, {2}, {3}, {3}, {1, 5}, {3}}; // yes
        int[][] input = {{}, {2}, {}, {0}, {2}}; // no

        List<List<Integer>> adj = new ArrayList<>();
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }

        int[] visited = new int[adj.size()];
        int[] pathVisited = new int[adj.size()];

        boolean ans = false;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            pathVisited[i] = 1;
            if (detectCycle(adj, i, visited, pathVisited)) {
                ans = true;
                break;
            }
            pathVisited[i] = 0;
        }
        System.out.println("The graph has cycle: " + ans);
    }

}
