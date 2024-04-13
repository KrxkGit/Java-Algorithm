package leetcode;

import java.util.Arrays;

/**
 * 本代码存在边界问题
 */

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

}
