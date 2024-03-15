package leetcode;

public class MaximalSquare {
    private int m, n;
    /**
     * 考虑边界后统一返回矩阵的值
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    protected int considerBound(char[][]matrix, int i, int j) {
        if (i < 0 || j < 0) {
            return 0; // 边界外统一为 0
        } else if (i >= m || j >= n) {
            return 0;
        } else {
            return matrix[i][j] == '0' ? 0 : 1;
        }
    }

    /**
     * 初始化
     * @param matrix
     */
    protected void init(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
    }

    /**
     * 检查是否外围 是否 全 1
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    protected boolean isAroundTrue(char[][] matrix, int i, int j, int S) {
        if (considerBound(matrix, i, j) == 0) {
            return false;
        }
        int sideLength = (int) Math.sqrt(S);
        for (int k = 1; k <= sideLength; k++) {
            if (considerBound(matrix, i, j - k) == 0 || considerBound(matrix, i - k, j)  == 0) {
                return false;
            }
        }
        return true;
    }
    public int maximalSquare(char[][] matrix) {
        init(matrix);
        int[][] dp = new int[m][n];

        int save = 0;
        // init dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                save = Math.max(save, dp[i][j]);
            }
        }

        // transition
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int S = dp[i - 1][j - 1];
                // 继承原来的
                if (isAroundTrue(matrix, i, j, S)) {
                    dp[i][j] = (int) (S + 2 * Math.sqrt(S) + 1);
                } else {
                    // 在初始化时已处理
//                    dp[i][j] = 1;
                }
                // 重新开辟
                int tempSave;
                while (S > 1) {
                    S = (int) Math.pow(Math.sqrt(S) - 1, 2);
                    if (isAroundTrue(matrix, i, j, S)) {
                        tempSave = dp[i][j]; // 临时保存
                        dp[i][j] = Math.max(dp[i][j], (int) (S + 2 * Math.sqrt(S) + 1));
                        if (dp[i][j] == tempSave) { // 不可能更大，剪枝
                            break;
                        }
                    }
                }

                save = Math.max(save, dp[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }

        return save;
    }
}
