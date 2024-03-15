package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 采用滑动窗口
 */
public class LengthOfLongestSubstring {
    /**
     * 为了确保无重复字符串，滑动窗口必须由小向大扩展，且移动方向唯一以简化问题
     * 注意明确指针的涵义与初始状态
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int rk = 0;
        int res = 0;
        Set<Character> hashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            while (rk < s.length() && !hashSet.contains(s.charAt(rk))) {
                hashSet.add(s.charAt(rk));
                rk++;
            }
            res = Math.max(res, rk - i);
        }
        return res;
    }
}
