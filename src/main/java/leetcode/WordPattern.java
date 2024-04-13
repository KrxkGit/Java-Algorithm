package leetcode;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] pat = pattern.toCharArray();
        String[] splitRes = s.split(" ");
        if (pat.length != splitRes.length) {
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        HashMap<String, Character> hashMap1 = new HashMap<>();
        int cur = 0;
        for (Character p : pat) {
            String temp = hashMap.get(p);
            if (temp == null) {
                hashMap.put(p, splitRes[cur]);
            } else {
                if (!temp.equals(splitRes[cur])) {
                    return false;
                }
            }
            cur++;
        }

        cur = 0;
        for (String x : splitRes) {
            Character p = hashMap1.get(x);
            if (p == null) {
                hashMap1.put(x, pat[cur]);
            } else {
                if (!p.equals(pat[cur])) {
                    return false;
                }
            }
            cur++;
        }
        return true;
    }
}
