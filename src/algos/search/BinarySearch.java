package algos.search;

public class BinarySearch {
    private static int isNumberPresent(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9, 24, 345};
        int targetIndex = isNumberPresent(arr, 345);
        System.out.println(targetIndex);
    }
}
