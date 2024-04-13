package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目偏难，暂时放弃
 */
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsIndex = 0;
        int resultIndex = 0;
        int remain = maxWidth;

        List<String> resultList = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        while (remain >= words[wordsIndex].length()) {
            if (wordsIndex < words.length - 1 && words[wordsIndex + 1].length() <= remain - 1) { // 下一个继续插入
                builder.append(words[wordsIndex]);
                builder.append(" ");
            } else { // 下一个插不进，中间空格填充

            }
        }
        return null;
    }
}
