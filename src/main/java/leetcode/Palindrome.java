package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
