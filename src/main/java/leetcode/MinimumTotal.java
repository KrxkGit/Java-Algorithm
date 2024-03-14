package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分别采用 回溯算法 与 动态规划 解决问题
 */
public class MinimumTotal {
    private List<Integer> result = new ArrayList<>();
    public int minimumTotalBacktrace(List<List<Integer>> triangle) { // 采用回溯算法
        List<Integer>path = new ArrayList<>();
        backtrace(path, triangle, 0, triangle.size(), 0);

        int save = Integer.MAX_VALUE;
        for (int item : result) {
            save = Math.min(save, item);
        }
        return save;
    }
    protected void backtrace(List<Integer> path, List<List<Integer>> triangle, int len, int wantedLen, int lastIndex) {
        if (len == wantedLen) {
            int sum = 0;
            for (int item : path) {
                sum += item;
            }
            result.add(sum);
            return;
        }

        List<Integer> current = triangle.get(len);
        int index = -1;

        for (Integer nextChoice : current) {
            index++;
            if (index != lastIndex && index != lastIndex + 1) {
                continue;
            }
            path.add(nextChoice);
            backtrace(path, triangle, len + 1, wantedLen, index);
            path.remove(path.size() - 1);
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) { // 采用 动态规划
        int size = triangle.size();
        int[][] dp = new int[size][size]; // i 层 所在层 第 j 个 的元素 对应路径的最小和
        // init
        dp[0][0] = triangle.get(0).get(0);

        int save = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            List<Integer> current = triangle.get(i);

            dp[i][0] = dp[i - 1][0] + current.get(0); // 头部
            for (int j = 1; j < i; j++) { // 中间
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + current.get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + current.get(i);
        }

        for (int i = 0; i < size; i++) {
            save = Math.min(dp[size - 1][i], save);
        }

        return save;
    }
}
