package algos.fifty.arraysandhash;

import java.util.*;

public class TopKFrequentElements {
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> a.getValue() >= b.getValue() ? a.getValue() > b.getValue() ? -1 : 0 : 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.poll().getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 2, 2, 3, 4};
        int[] ans = topKFrequent(input, 2);
        System.out.println(Arrays.toString(ans));
    }
}
