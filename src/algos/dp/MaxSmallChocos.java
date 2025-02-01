package algos.dp;

public class MaxSmallChocos {

    private static int min(int index, int[] choco, int[] chocoWeight, int rw) {
        if (rw == 0) {
            return 0;
        }

        if (index == 0) {
            if (rw % chocoWeight[index] == 0 && rw / chocoWeight[index] <= choco[0]) {
                return rw / chocoWeight[index];
            }
            return Integer.MIN_VALUE;
        }

        int notTake = min(index - 1, choco, chocoWeight, rw);
        int take = Integer.MIN_VALUE;
        if (rw >= chocoWeight[index]&& choco[index] > 0) {
            choco[index] = choco[index] - 1;
            int wt = chocoWeight[index];
            take = min(index, choco, chocoWeight, rw - wt);
            if (take != Integer.MIN_VALUE) {
                take = 1 + take;
            }
        }
        return Math.max(take, notTake);
    }

    private static int maxNumberOfChocos(int ns, int nb, int[] chocoWeight, int rw) {
        if (ns > rw && nb > rw) {
            return -1;
        }

        int[] choco = new int[2];
        choco[0] = ns;
        choco[1] = nb;

        int res = min(1, choco, chocoWeight, rw);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] chocoWeight = {2, 3};
        System.out.println(maxNumberOfChocos(5, 1, chocoWeight, 14));
    }
}
