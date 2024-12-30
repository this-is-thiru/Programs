package algos.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindEventualSafeStatesDFS16 {
    private static boolean detectCycle(List<List<Integer>> adj, int node, int[] visited, int[] pathVisited, int[] safeNodes) {
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                visited[adjNode] = 1;
                pathVisited[adjNode] = 1;
                safeNodes[adjNode] = 0;
                if (detectCycle(adj, adjNode, visited, pathVisited, safeNodes)){
                    return true;
                }
                pathVisited[adjNode] = 0;
                safeNodes[adjNode] = 1;
            } else if (pathVisited[adjNode] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] input = {{1, 2}, {3}, {}, {}, {1, 5}, {3}}; // no
//        int[][] input = {{1,2}, {2}, {0, 3}, {3}}; // yes
        int[][] input = {{1}, {2}, {3}, {3}, {1, 5}, {3}}; // yes
//        int[][] input = {{}, {2}, {}, {0}, {2}}; // no

        List<List<Integer>> adj = new ArrayList<>();
        for (int[] arr : input) {
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            adj.add(list);
        }

        int[] visited = new int[adj.size()];
        int[] pathVisited = new int[adj.size()];
        int[] safeNodes = new int[adj.size()];

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            pathVisited[i] = 1;
            safeNodes[i] = 0;
            if(detectCycle(adj, i, visited, pathVisited, safeNodes)) {
                continue;
            }
            pathVisited[i] = 0;
            safeNodes[i] = 1;
        }

        System.out.print("Eventual safe nodes: ");
        for (int i=0; i<safeNodes.length; i++) {
            if (safeNodes[i] == 1) {
                System.out.print(i + ", ");
            }
        }
    }
}
