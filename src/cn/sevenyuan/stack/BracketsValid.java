package cn.sevenyuan.stack;

import java.util.Stack;

/**
 * 判断字符串括号是否合法
 *
 * @author JingQ at 2021/5/24
 */
public class BracketsValid {

    /**
     * 使用栈实现判断是否有效括号字符串
     *
     * @param s 字符串
     * @return  是否有效
     * @throws Exception    异常
     */
    public static boolean isValid1(String s) throws Exception {
        String newStr = validateAndTrim(s);
        if (newStr == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = newStr.toCharArray();
        for (char c : chars) {
            // 左括号，压栈
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // 如果是空栈，表示匹配失败
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            } else {
                throw new Exception("识别到错误编码");
            }

        }
        // 栈为空说明匹配完整，是个合法的字符串括号
        return stack.isEmpty();
    }

    /**
     * 不用栈，使用一个数值保存左括号数量，来判断字符串括号是否有效。
     *
     * @param s 字符串括号
     * @return  是否有效
     */
    public static boolean isValid2(String s) {
        String newStr = validateAndTrim(s);
        if (newStr == null) {
            return false;
        }
        // 判断左括号剩下多少个
        int leftBraceNumber = 0;
        char[] charArray = newStr.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                leftBraceNumber++;
            } else if (c == ')') {
                // 说明已经没有左括号可以匹配，返回 false
                if (leftBraceNumber <= 0) {
                    return false;
                }
                leftBraceNumber--;
            }
        }
        return leftBraceNumber == 0;
    }

    private static String validateAndTrim(String s) {
        // 考虑边界值，如果字符串为空
        if (s == null || s.trim().length() == 0) {
            return null;
        }
        s = s.trim();
        int length = s.length();
        // 如果字符长度不是偶数，无法匹配完整
        if (length % 2 != 0) {
            return null;
        }
        return s;
    }

}
