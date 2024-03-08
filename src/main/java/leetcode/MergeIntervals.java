package leetcode;


import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public MergeIntervals() {
        int[][] intervals = {{1,4}, {0,1}};
        display(merge(intervals));
    }
    protected void display(int[][] res) {
        for (int[] item : res) {
            System.out.printf("[%d, %d] ", item[0], item[1]);
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // 区间按结束位置升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[1], b = o2[1];
                if (a == b) {
                    return 0;
                } else if (a < b) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        // start 不断向前覆盖
        int[][] result = new int[intervals.length + 1][2];
        // 手动修正 result[0]
        result[0] = new int[]{-1, -1};

        int cur = 0;
        for (int[] childItem : intervals) {
            boolean status = true;
            int[] child = childItem;
            while (cur >= 0 && status) {
                // 循环穿越
                if (child[0] <= result[cur][0]) {
                    result[cur][0] = child[0];
                    result[cur][1] = child[1];

                    child = result[cur];
                    cur--;
                } else if (child[0] <= result[cur][1]) {
                    result[cur][1] = child[1];

                    child = result[cur];
                    cur--;
                } else {
                    cur++;
                    result[cur] = child;
                    status = false;
                }
            }
        }
        if (cur + 1 == 0) {
            cur += 2;
        }
        result = Arrays.copyOfRange(result, 1, cur + 1);
        return result;
    }
    private class Interval {
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval() {
        }
        public int start;
        public int end;
    }
}
