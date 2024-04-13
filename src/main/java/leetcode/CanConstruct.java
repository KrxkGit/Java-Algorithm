package leetcode;

import java.util.HashMap;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>(magazine.length());
        char[] atoms = magazine.toCharArray();
        for (char x : atoms) {
            Integer count = hashMap.get(x);
            if (count == null) {
                hashMap.put(x, 1);
            } else {
                hashMap.put(x, count + 1);
            }
        }

        char[] maga = ransomNote.toCharArray();
        for (char x : maga) {
            Integer count = hashMap.get(x);
            if (count == null) {
                return false;
            } else {
                if (count == 1) {
                    hashMap.remove(x);
                } else  {
                    hashMap.put(x, count - 1);
                }
            }
        }
        return true;
    }
}
