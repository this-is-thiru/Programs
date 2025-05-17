public class Temp {
    private static int helper(int index, int count, int sum, int[] arr, int d) {
        if (index >= 0 && count == 3) {
            return 1;
        }

        if (index < 0) {
            return 0;
        }

        int take = helper(index - 1, count + 1, sum + arr[index], arr, d);
        int notTake = helper(index - 1, count, sum, arr, d);

        return take + notTake;
    }
    private static int findCount(int[] arr, int d) {

        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
    }
}
