package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
    private LinkedHashMap<Integer, Character> map = new LinkedHashMap<>();
    private Map<Character, String> twiceMap = new HashMap<>();
    private Integer[] arr;
    int cur;
    public IntToRoman() {
        map.put(1, 'I');
        map.put(4, 'a');
        map.put(5, 'V');
        map.put(9, 'A');
        map.put(10, 'X');
        map.put(40, 'b');
        map.put(50, 'L');
        map.put(90, 'B');
        map.put(100, 'C');
        map.put(400, 'e');
        map.put(500, 'D');
        map.put(900, 'E');
        map.put(1000, 'M');

        arr = map.keySet().toArray(new Integer[0]);
        Arrays.sort(arr);
        cur = arr.length - 1;

        twiceMap.put('a', "IV");
        twiceMap.put('A', "IX");
        twiceMap.put('b', "XL");
        twiceMap.put('B', "XC");
        twiceMap.put('e', "CD");
        twiceMap.put('E', "CM");
    }
    public String test(int num) {
        // 贪心算法

        // 先不考虑倒序

        // 考虑以下特殊情况
        // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。


        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (int j = cur; j >= 0; j--) {
                int temp = arr[j];
                if (num >= temp) {
                    num -= temp;
                    Character temp1= map.get(temp);
                    String twiceTemp = twiceMap.get(temp1);
                    if (twiceTemp == null) {
                        result.append(map.get(temp));
                    }
                    else {
                        result.append(twiceTemp);
                    }
                    cur = j;
                    break;
                }
            }
        }
        String res = result.toString();
        System.out.println(res);
        return res;
    }
}
