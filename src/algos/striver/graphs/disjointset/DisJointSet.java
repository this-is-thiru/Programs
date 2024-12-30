package algos.striver.graphs.disjointset;

public class DisJointSet {
    int[] size;
    int[] parent;

    DisJointSet(int n) {
        int plusOne = n + 1;
        size = new int[plusOne];
        parent = new int[plusOne];
        for (int i = 0; i < plusOne; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    void areConnectedComponents(int a, int b) {
        if (parent[a] == parent[b]) {
            System.out.println("Yes, " + a + ", " + b + " are connected.");
            return;
        }
        System.out.println("No, " + a + ", " + b + " are connected.");
    }

    private int ultimateParent(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = ultimateParent(parent[u]);
    }

    void unionBySize(int u, int v) {
        int ulp_u = ultimateParent(u);
        int ulp_v = ultimateParent(v);

        if (ulp_u == ulp_v) return;
        if (size[ulp_u] >= size[ulp_v]) {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        } else {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }

    public static void main(String[] args) {
        DisJointSet djs = new DisJointSet(10);
        djs.unionBySize(0, 1);
        djs.unionBySize(1, 3);
        djs.unionBySize(2, 5);
        djs.unionBySize(2, 8);
        djs.unionBySize(9, 4);
        djs.unionBySize(6, 9);
        djs.areConnectedComponents(0, 3);
        djs.areConnectedComponents(1, 9);

        djs.unionBySize(3, 9);
        djs.areConnectedComponents(1, 9);
        djs.areConnectedComponents(2, 9);

        djs.unionBySize(4, 2);
        djs.areConnectedComponents(2, 9);
    }
}
