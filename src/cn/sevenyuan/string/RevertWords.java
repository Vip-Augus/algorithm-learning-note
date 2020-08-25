package cn.sevenyuan.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JingQ at 2020/4/18
 */
public class RevertWords {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        Map<Integer, String> map = new HashMap<>();
        char[] str = s.toCharArray();
        int position = 0;
        int preIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ' && i != str.length - 1) {
                continue;
            }
            if (i > 0 && str[i] == ' ' && str[i - 1] == ' ') {
                preIndex++;
                continue;
            }
            // 表示遇到空格，前面的字符可以添加到 map 中
            map.put(position, s.substring(preIndex, i == str.length - 1 ? str.length : i));
            position++;
            preIndex = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = position - 1; i >= 0; i--) {
            sb.append(map.get(i));
            if (i != 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
