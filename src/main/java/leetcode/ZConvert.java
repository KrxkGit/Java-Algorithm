package leetcode;

/**
 * 字符串的 Z 变换
 */
public class ZConvert {
    private int m, n;
    private int stepChoice; // 0 向下，1 右上
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        this.m = numRows;
        this.n = len * 2 / 3; // 足够存储
        stepChoice = 1; // 初始状态为向右上，因为 (0,0) 为起点将发生切换

        char[][] arr = new char[m][n];

        int i = 0, j = 0;
        for (int k = 0; k < len; k++) {
            arr[i][j] = s.charAt(k);
            int[] t = goNext(i, j);
            i = t[0];
            j = t[1];
        }

        StringBuilder res = new StringBuilder();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                res.append(arr[i][j]);
            }
        }
        return res.toString();

    }

    /**
     * 返回下一步的坐标
     * @param i
     * @param j
     * @return
     */
    protected int[] goNext(int i, int j) {
        // 向下 (i + 1, j)
        // 右上 (i - 1, j + 1)
        if (isReachBound(i)) {
            stepChoice = stepChoice == 0 ? 1 : 0;
        }

        if (stepChoice == 0) {
            return new int[]{i + 1, j};
        } else {
            return new int[]{i - 1, j + 1};
        }

    }
    protected boolean isReachBound(int i) {
        if (i <= 0 || i >= this.m - 1) {
            return true;
        } else {
            return false;
        }
    }
}
