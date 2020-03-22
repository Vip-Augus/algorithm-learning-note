package cn.sevenyuan.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 字符串的排列
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：使用回溯算法，同时每次固定某几个标志位，让其余的字符进行组合
 *
 * @author JingQ at 2020/3/22
 */
public class Permutation {

    public static void main(String[] args) {

    }

    private static ArrayList<String> res = new ArrayList<>();

    private static StringBuilder path = new StringBuilder();

    private static TreeSet<String> paths = new TreeSet<>();

    private static boolean[] visited;

    private static ArrayList<String> Permutation(String str) {
        if (str == null || "".equals(str)) {
            return res;
        }
        char[] strs = str.toCharArray();
        int strLength = strs.length;
        Arrays.sort(strs);
        visited = new boolean[strLength];
        combination(strs, 0, strLength);
        res.addAll(paths);
        return res;
    }

    private static void combination(char[] strs, int len, int strLength) {
        if (len == strLength) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < strLength; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(strs[i]);
                combination(strs, len + 1, strLength);
                // 回溯，将下标 i 对应字符重新放出来，并将之前加入的 path 删掉
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
