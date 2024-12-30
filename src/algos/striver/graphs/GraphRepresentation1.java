package algos.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphRepresentation1 {
    private static void listRepresentation(int nodes, int[][] edges) {
        System.out.println("Adjacency list representation of graph: ");
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= nodes; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];

            List<Integer> list = graph.get(x);
            list.add(y);

            list = graph.get(y);
            list.add(x);
        }

        System.out.println(graph);
    }

    private static void matrixRepresentation(int nodes, int[][] edges) {
        System.out.println("Adjacency matrix representation of graph: ");
        int[][] graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i <= nodes; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int[] edge : graph) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public static void main(String[] args) {
        int nodes = 5;
        // un-directed edges: 1->2, 1->3, 3->4, 2->4, 2->5, 4->5
        int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};
        listRepresentation(nodes, edges);
        matrixRepresentation(nodes, edges);
    }
}
