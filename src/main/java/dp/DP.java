package dp;

public class DP {
    private int called_count = 0;
    private int[] res;
    // 斐波拉切数列
    public DP() {
        int n = 11;
        System.out.printf("Result: %d\nCall_count: %d\n", dp_do(n), called_count);
    }
    public int dp_do(int n){
        called_count = 0; // 清空
        res = new int[n + 1];
        res[1] = res[2] = 1; // 初始化

//        return use_recursive(n);
        return use_dp(n);
    }
    public int use_recursive(int n) {
        called_count++;
        if (n == 1 || n == 2) {
            return 1;
        }
        return use_recursive(n - 1) + use_recursive(n - 2);
    }

    public int use_dp(int n) {
        for (int j = 3; j < n + 1; j++) {
            res[j] = res[j - 1] + res[j - 2];
            called_count++;
        }

        return res[n];
    }

}
