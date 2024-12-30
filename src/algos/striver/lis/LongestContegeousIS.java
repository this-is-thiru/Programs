package algos.striver.lis;

public class LongestContegeousIS {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int maxLength = 0;
        int startIndex = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                maxLength = Math.max(maxLength, i-startIndex);
                startIndex = i;
            }
        }

        if(startIndex == 0) return nums.length;
        return Math.max(maxLength, nums.length-startIndex);
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,3,4,5};
        int n = nums.length;

        int tabulationAnsBest = findLengthOfLCIS(nums);
        System.out.println("Total number of LIS: " + tabulationAnsBest);
    }
}
