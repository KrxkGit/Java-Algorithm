package greedy;

public class Greedy {
    private int count = 0;
    public Greedy() {
        int[] start = {2,4,4,12};
        int[] finish = {3,6,8,29};
        DoGreedy(start, finish);
        System.out.printf("Count: %d", count);
    }
    public void DoGreedy(int[] start, int[] finish) {
        int n = start.length; // 活动总数
        int prevFinish = 0;
        // 最大活动数
        // 贪心策略: 在前面决策基础上，只要时间允许就参加
        for (int i = 0; i < n ;i ++) {
            if (start[i] >= prevFinish) {
                count++;
                prevFinish = finish[i];
            }
        }
    }

    public int getCount() {
        return count;
    }
}
