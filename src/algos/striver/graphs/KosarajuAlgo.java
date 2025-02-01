package algos.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {
    private static void dfs(int node, int[] visited, List<List<Integer>> adjList, Stack<Integer> st) {
        visited[node] = 1;
        for (Integer adjNode : adjList.get(node)) {
            if (visited[adjNode] != 1) {
                dfs(adjNode, visited, adjList, st);
            }
        }
        st.add(node);
    }

    private static void dfs3(int node, int[] visited, List<List<Integer>> adjList,  List<Integer> list) {
        visited[node] = 1;
        list.add(node);
        for (Integer adjNode : adjList.get(node)) {
            if (visited[adjNode] != 1) {
                dfs3(adjNode, visited, adjList, list);
            }
        }
    }

    private static int kosaraju(List<List<Integer>> adj) {
        int[] visited = new int[adj.size() + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] != 1) {
                dfs(i, visited, adj, stack);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.size(); i++) {
            // i -> it
            // it -> i
            visited[i] = 0;
            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] != 1 && node != 0) {
                dfs3(node, visited, adjT, list);
                System.out.println(list);
                list.clear();
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] nodes = {{}, {3, 4}, {1}, {2}, {5}, {}};
        List<List<Integer>> adjList = new ArrayList<>();
        for (int[] arr : nodes) {
            List<Integer> adjNodes = Arrays.stream(arr).boxed().toList();
            adjList.add(adjNodes);
        }

        int sccs = kosaraju(adjList);
        System.out.println("Number of connected components: " + sccs);
    }
}
