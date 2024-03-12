package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯 算法
 */
public class PhoneNumber {
    private List<String> result;
    private HashMap<Character, String> map;

    public PhoneNumber() {
        List<String> res = letterCombinations("23");
        if (res.isEmpty()) {
            System.out.println("No data");
            return;
        }
        System.out.println(res.get(0));
    }

    protected void Init() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        result = new LinkedList<>();
    }
    public List<String> letterCombinations(String digits) {
        Init();
        String path = "";
        backtrace(digits, 0, path, digits.length());
        if (result.size() == 1 && result.get(0) == "") {
            return new ArrayList<>();
        }
        return result;
    }
    protected void backtrace(String digits, int choiceIndex,String path, int wantedLength) {
        if (path.length() == wantedLength) {
            result.add(path);
            return;
        }
        if (choiceIndex >= digits.length()) {
            return;
        }
        // 选择
        Character choiceChar = digits.charAt(choiceIndex);
        String choices =  map.get(choiceChar);
        for (int i = 0; i < choices.length(); i++) {
            path += choices.charAt(i);
            backtrace(digits, choiceIndex + 1, path, wantedLength);
            path = path.substring(0, path.length() - 1);
        }
    }
}
