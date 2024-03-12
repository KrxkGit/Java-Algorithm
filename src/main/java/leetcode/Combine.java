package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>path = new LinkedList<>();
        backtrace(path, k, n);
        return result;
    }
    protected void backtrace(List<Integer>path, int k, int n) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isExist(path, i)) { // 剪枝
                return;
            }
            path.add(i);
            backtrace(path, k, n);
            path.remove(path.indexOf(i));
        }
    }
    protected boolean isExist(List<Integer>path, int c) {
        for (int i = 0; i < path.size(); i++) {
            if (c == path.get(i)) {
                return true;
            }
        }
        return false;
    }
}
