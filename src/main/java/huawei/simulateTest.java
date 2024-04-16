package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class simulateTest {
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] splitRes = input.split(" ");
        int sum = 0;
        for (String x : splitRes) {
            sum += x.length();
        }
        double result = sum / (double)splitRes.length;
        System.out.printf("%.2f\n", result);
    }

    public void test2() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] sArr = input.toLowerCase().toCharArray();
        int diff = 'A' - 'a';
        for (int i = 0; i < sArr.length; i++) {
            if (isVowel(sArr[i])) {
                sArr[i] += diff;
            }
        }
        System.out.println(sArr);

    }

    protected boolean isVowel(char c) {
        char[] vowel1 = {'a', 'e', 'i', 'o', 'u'};
        char[] vowel2 = {'a', 'e', 'i', 'o', 'u'};
        for (char c1 : vowel1) {
            if (c == c1) {
                return true;
            }
        }
        for (char c1 : vowel2) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 全排列 / 每个字母的全排列 乘积
     */
    public void test3() {
        Scanner s = new Scanner(System.in);
        char[] chars = s.nextLine().toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int num = 0;
        for (char ch:chars) {
            if(null == map.get(ch)) {
                num = 0;
            } else {
                num = map.get(ch);
            }
            map.put(ch,num + 1);
        }
        int allSort = SortOne(chars.length);
        for (char key : map.keySet()) {
            allSort = allSort/SortOne(map.get(key));
        }
        System.out.println(allSort);
    }

    int SortOne (int charsNum) {
        if (charsNum == 1) {
            return 1;
        }
        return charsNum * SortOne(charsNum - 1);
    }

}
