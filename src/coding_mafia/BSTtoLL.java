package coding_mafia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BSTtoLL {

    private static List<Integer> bstToLL(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (num != -1) {
                ans.add(num);
            }
        }
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 10, 2, 6, -1, -1, -1, -1, -1, 7, -1, -1};

        System.out.println(bstToLL(arr));
    }
}
