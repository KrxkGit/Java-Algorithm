package leetcode;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        String[] res = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i].length() == 0) {
                continue;
            }
            builder.append(res[i]);
            builder.append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
