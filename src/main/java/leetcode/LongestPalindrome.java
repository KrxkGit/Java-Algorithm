package leetcode;

/**
 * 多维动态规划
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        boolean[][] p = new boolean[s.length()][s.length()]; // p[i][j] 表示 s[i : j] 为 回文字符串
        int begin = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            p[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                boolean b = s.charAt(i) == s.charAt(j);

                if (i == j) {
                    p[i][j] = true; // 长度为 1 必是回文
//                    maxLen = Math.max(maxLen, 1);
                    int len = j - i + 1;
                    if (p[i][j] && len > maxLen) {
                        maxLen = len;
                        begin = i;
                    }
                    continue;
                } else if (i + 1 == j) {
                    p[i][j] = b;
                    int len = j - i + 1;
                    if (p[i][j] && len > maxLen) {
                        maxLen = len;
                        begin = i;
                    }
                    continue;
                }
                if (b) {
                    p[i][j] = p[i + 1][j - 1]; // 由此分析依赖性，先计算 大 i, 小 j
                    int len = j - i + 1;
                    if (p[i][j] && len > maxLen) {
                        maxLen = len;
                        begin = i;
                    }
                } else {
                    p[i][j] = false;
                }

            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
