package leetcode;

/**
 * 暴力算法 O(m * n)
 * KMP 算法 O(m + n)
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        boolean strategy = false; // 是否采用 kmp 算法

        if (!strategy) {
            return violence(haystack, needle);
        } else {
            return use_kmp(haystack, needle);
        }
    }

    /**
     * 采用暴力算法
     * 复杂度 O(m * n)
     * @param haystack
     * @param needle
     * @return
     */
    protected int violence(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        int haystackLen = haystackArray.length;
        int needleLen = needleArray.length;
        // 滑动窗口
        for (int i = 0; i + needleLen <= haystackLen; i++) { // 窗口起点
            boolean status = true;
            for (int j = 0; j < needleLen; j++) {
                if (haystackArray[i + j] != needleArray[j]) {
                    status = false;
                    break;
                }
            }

            if (status) {
                return i;
            }
        }

        return -1;
    }

    protected int use_kmp(String haystack, String needle) {
        return -1;
    }
}
