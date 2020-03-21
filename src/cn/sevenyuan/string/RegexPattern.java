package cn.sevenyuan.string;

/**
 * 正则表达式
 *
 * @author JingQ at 2020/3/21
 */
public class RegexPattern {

    public static void main(String[] args) {

    }

    private static boolean matchChar(char[] str, char[] pattern, int s, int p) {
        if (str == null || pattern == null) {
            return false;
        }
        if (s == str.length && p == pattern.length) {
            return true;
        }
        // 如果还没抵达被匹配字符的末尾，而 pattern 已走完，返回 false
        if (s < str.length && p == pattern.length) {
            return false;
        }
        // 对于星号 * 和点 . 进行特殊判断
        if ((p + 1) < pattern.length && pattern[p + 1] == '*') {
            // 如果当前被匹配字符长度未达到，并且 pattern 模式 * 号前的字符与 s 下标相等，获取是点，进行下一轮匹配
            if (s < str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                return matchChar(str, pattern, s, p + 2) ||
                        matchChar(str, pattern, s + 1, p + 2) ||
                        matchChar(str, pattern, s + 1, p);
            } else {
                return matchChar(str, pattern, s, p + 2);
            }
        } else if (s < str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
            return matchChar(str, pattern, s + 1, p + 1);
        }
        return false;
    }
}
