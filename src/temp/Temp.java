package temp;

import java.util.HashMap;
import java.util.Map;

public class Temp {
    public static void main(String[] args) {
        int[] arr = {2,4,6,3,2,4,7,8};
        int k = 2;
        int ans = getNonRepeatingNum(arr, k);
        System.out.println(ans);
    }

    private static int getNonRepeatingNum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                count++;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }

        int counter = k;
        for (int num: arr) {
            if (map.get(num) ==1) {
                counter--;
            }

            if (counter ==0) {
                return num;
            }
        }
        return -1;
    }
}
