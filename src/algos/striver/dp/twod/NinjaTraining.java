package algos.striver.dp.twod;

public class NinjaTraining {
    private static int maxPoints(int index, int n, int[][] trainPoints,int chosenTask) {
        if (index == n-1) {
            int[] points = trainPoints[index];
            int max = 0;
            for (int i=0; i<3; i++) {
                if (i == chosenTask) {
                    continue;
                }
                max = Math.max(points[i], max);
            }
            return max;
        }

        int max = 0;
        int[] points = trainPoints[index];
        for (int i = 0; i < 3; i++) {
            if (i==chosenTask){
                continue;
            }
            int curPoints = points[i] + maxPoints(index+1, n, trainPoints, i);
            max=Math.max(curPoints, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trainPoints = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int max = maxPoints(0, n, trainPoints, -1);
        System.out.println("Points: " + max);
    }
}
