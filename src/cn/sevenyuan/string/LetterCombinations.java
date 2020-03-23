package cn.sevenyuan.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JingQ at 2020/3/23
 */
public class LetterCombinations {


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        String[] board = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(list, digits, new String(), board, 0);
        return list;
    }

    private void backtrack(List<String> list, String s, String newStr, String[] board, int start) {
        if (start == s.length()) {
            list.add(newStr);
            return;
        }
        for (char c : board[(s.charAt(start) - '2')].toCharArray()) {
            backtrack(list, s, newStr + c, board, start + 1);
        }
    }
}
