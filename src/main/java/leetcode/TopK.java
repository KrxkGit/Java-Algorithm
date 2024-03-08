package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (int item : nums) {
            priorityQueue.add(item);
        }
        while (k > 1) {
            k--;
            priorityQueue.remove();
        }
        return priorityQueue.poll();
    }
}
