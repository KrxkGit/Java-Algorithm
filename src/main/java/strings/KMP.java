package strings;

public class KMP {
    public KMP() {
        String str = "Krxk5ssa";
        String pat = "k5s";
        System.out.printf("Brute Position: %d\n", Brute(str, pat));
        System.out.printf("KMP Position: %d\n", Use_kmp(str, pat));
    }

    public int Brute(String str, String pattern) { // 暴力算法
        // 返回子串位于主串的索引
        char[] main =  str.toCharArray();
        char[] pat = pattern.toCharArray();
        boolean bStatus = false;

        // 模式字符串可作为整体
        for (int i = 0; i < main.length; i++) {
            if (IsStartWith(main, pat, i)) {
                return i;
            }
        }
        return -1;
    }
    protected boolean IsStartWith(char[] main, char[] pat, int main_shift) {
        if (pat.length > main.length - main_shift) {
            return false;
        }
        boolean status = true;
        for (int i = 0; i < pat.length; i++) {
            if (main[i + main_shift] != pat[i]) {
                status = false;
                break;
            }
        }
        return status;
    }
    public int Use_kmp(String str, String pattern) {
        // 返回子串位于主串的索引
        char[] main =  str.toCharArray();
        char[] pat = pattern.toCharArray();
        boolean bStatus = false;

        /*
         Brute 算法的优化点: 考虑更优化的 main_shift，而不是每次只移动 1
         那么最优是移动多少？ ->  应保证移动后仍然为部分匹配状态（且是最大匹配）
         一种特殊情况: 移动到下一个首字母匹配的地方 -> 一般情况：最长公共前后缀
         模式字符串可作为整体
        */
        int[] lps = build_next(pat);
        int i = 0, j = 0; // 分别为 主串 和 子串 的索引
        while (i < main.length) {
            if (main[i] == pat[j]) {
                i++;
                j++;
            }
            if (j == pat.length) {
                return i - j;
            } else if (i < main.length && main[i] != pat[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    /**
     * 构建 next 表
     * @param matched 已经匹配的字符模式
     * @return
     */
    protected int[] build_next(char[] matched) {
        int[] lps = new int[matched.length];
        int len = 0; // 记录 移动到最近相同字符的最小步数 && 当前要匹配的字符的索引
        int i = 1;
        while (i < matched.length) {
            if (matched[i] == matched[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // 考虑边界
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
