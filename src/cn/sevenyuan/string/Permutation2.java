package cn.sevenyuan.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排列
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 思路：使用递归算法
 *
 * @author JingQ at 2020/8/30
 */
public class Permutation2 {

    public static void main(String[] args) {
        permutation("ABC");
        System.out.println(res);
    }

    private static ArrayList<String> res = new ArrayList<>();

    private static ArrayList<String> permutation(String str) {
        if (str == null || "".equals(str)) {
            return res;
        }
        return permutation(str.toCharArray(), 0);
    }

    private static ArrayList<String> permutation(char[] strArr, int index) {
        if (index == strArr.length - 1) {
            res.add(Arrays.toString(strArr));
        }
        for (int i = index; i < strArr.length; ++i) {
            //首个字符和它后面的字符（包括自己）进行交换
            char temp = strArr[i];
            strArr[i] = strArr[index];
            strArr[index] = temp;
            //递归求后面的字符的排列
            permutation(strArr, index + 1);
            //进行还原
            temp = strArr[index];
            strArr[index] = strArr[i];
            strArr[i] = temp;
        }
        return res;
    }

}
