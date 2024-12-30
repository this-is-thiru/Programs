package algos.striver.graphs;

public class NumberOfProvinces4 {

    private static void dfs(int[][] adj, int[] visited, int node) {
        if (visited[node] == 1) {
            return;
        }
        visited[node] = 1;
        int[] adjNodes = adj[node];
        for (int adjNode = 0; adjNode<adjNodes.length; adjNode++) {
            if (adjNodes[adjNode] == 1) {
                dfs(adj, visited, adjNode);
            }

        }
    }

    private static void numberOfProvinces(int[][] adj) {
        int n = adj.length;
        int[] visited = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(adj, visited, i);
                count++;
            }
        }

        System.out.println("Count of provinces: " + count);
    }

    public static void main(String[] args) {
//        int[][] input = {
//                {1, 0, 1},
//                {0, 1, 0},
//                {1, 0, 1}
//        };

//        int[][] input = {
//                {1, 1},
//                {1, 1}
//        };

        int[][] input = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}

        };

        numberOfProvinces(input);
    }
}
