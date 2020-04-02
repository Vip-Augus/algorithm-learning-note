package cn.sevenyuan.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 使用双指针加 set 去重
 *
 * @author JingQ at 2020/3/29
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0, len = s.length();
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < len && j < len) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

}
