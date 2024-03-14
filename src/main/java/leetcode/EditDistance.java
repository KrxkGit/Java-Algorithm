package leetcode;

public class EditDistance {
    public int minDistanceFail(String word1, String word2) { // 失败算法
        char[] sz1 = word1.toCharArray();
        char[] sz2 = word2.toCharArray();

        int m = sz1.length, n = sz2.length;
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }

        int saveChange = 0;

        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i >= m) {
                i -= 1;
            } else if (j >= n) {
                j -= 1;
            }
            if (sz1[i] != sz2[j]) {
                saveChange++;
            }
            if (i < m) {
                i++;
            }
            if (j < n) {
                j++;
            }
        }
        return saveChange;
    }

    public int minDistance(String word1, String word2) { // 成功算法
        int m = word1.length(), n = word2.length();

        // dp(i,j)是i,j指针指向子串末尾时的两个子串的最小编辑距离，m + 1, n + 1 是末尾留一个用于插入新字符的位置
        int dp[][] = new int[m + 1][n + 1];

        if (m*n == 0) {
            return m + n;
        }
        // 初始化
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
