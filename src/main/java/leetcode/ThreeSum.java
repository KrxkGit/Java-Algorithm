package leetcode;

import java.util.*;

/**
 * 此方案超时
 * 但涉及到 Java 底层
 */
public class ThreeSum {
    private HashSet<segment> cache = new HashSet<>() {
        @Override
        public boolean contains(Object o) {
            for (Object obj : this.toArray()) {
                if (obj.equals(o)) {
                    System.out.println("existed");
                    return true;
                }
            }
            return false;
        }
    };
    class segment {
        public segment(int[] nums) {
            this.nums = nums;
        }

        private HashSet<Integer> innerSeg = new HashSet<>(3);
        private int sum = 0;
        private int[] nums;
        private String save;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof segment seg) {
                if (seg.save.equals(this.save)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            segment seg = new segment(this.nums);
            seg.save = this.toString();
            return seg;
        }

        public boolean add(int num) {
            boolean existed = innerSeg.contains(num);
            if (existed) {
//                System.out.printf("fail: %s\n",this.toString());
                return false;
            } else {
                innerSeg.add(num);
                sum += nums[num];
                return true; // 添加成功
            }
        }
        public void remove(int num) {
//            System.out.printf("remove %d in %s\n",num, this.toString());
            sum -= nums[num];
            innerSeg.remove(num);
        }
        public boolean reachLen() {
            if (innerSeg.size() >= 3) {
                this.save = this.toString();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Integer[] temp = innerSeg.toArray(new Integer[0]);
            Integer[] tempNum = new Integer[temp.length];
            for (int i = 0; i < temp.length; i++) {
                tempNum[i] = nums[temp[i]];
            }
            Arrays.sort(tempNum);
            for (int i = 0; i < temp.length; i++) {
                builder.append(tempNum[i]);
                builder.append(' ');
            }
            return builder.toString();
        }

        public List<Integer> getResult() {
            assert reachLen(); // 假设长度到达

            if (sum == 0) {
                List<Integer> res = new ArrayList<>(3);
                for(Integer t : innerSeg.toArray(new Integer[0])) {
                    res.add(nums[t]);
                }
                return res;
            }
            return null;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalResult = new LinkedList<>();
        segment segObj = new segment(nums);
        backtrace(nums, segObj, finalResult, 0);

        return finalResult;
    }
    public void backtrace(int[] nums, segment segObj, List<List<Integer>> finalResult, int startIndex) {
        if (segObj.reachLen()) {
            List<Integer> midResult = segObj.getResult();
            if (midResult != null && !cache.contains(segObj)) {
                System.out.println(segObj.toString());
                try {
                    cache.add((segment) segObj.clone());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finalResult.add(midResult);
//                System.out.println(segObj.toString());
            }
            return;

        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!segObj.add(i)) {
                continue;
            }
            backtrace(nums, segObj, finalResult, i + 1); // 当前扫描位的后一个扫描位开始
            segObj.remove(i);
        }
    }
}
