package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 双指针与滑动窗口的区别在于：双指针范围是夹逼产生的，而滑动窗口是滑动产生的，滑动相比于夹逼更复杂
 */

public class Palindrome {
    public Palindrome() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        String result = "";
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            result += matcher.group();
        }

        result = result.toLowerCase();


        for (int i = 0, j = result.length() -1; i <= j; i++, j--) {
            if (result.charAt(i) != result.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
