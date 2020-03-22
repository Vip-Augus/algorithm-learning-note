package cn.sevenyuan.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 寻找最大回文，https://blog.csdn.net/zhou_209/article/details/90547718
 * <p>
 * https://www.nowcoder.com/profile/145758543/codeBookDetail?submissionId=55484263
 * <p>
 * 思路
 * 1：动态规划 Dynamic Programming
 * 2：中心扩散法
 *
 * @author JingQ at 3/21/20
 */
public class FindLargestPalindrome {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(longestPalindrome(s));
    }

    /**
     * 解法一，使用动态规划 Dynamic
     *
     * @param s
     * @return
     */
    private static String palindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        // 定义二维数组，dp 的值为 1 表示 true
        int[][] dp = new int[length][length];
        // 回文串的开始位置
        int start = 0;
        // 回文串的最大长度
        int max = 1;
        // 初始化，单个字符自身属于回文，连续的字符也属于回文
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                max = 2;
            }
        }

        // l 代表检索的子串长度，等于 3 表示先检索长度为 3 的子串
        for (int l = 3; l <= length; l++) {
            for (int i = 0; l + i - 1 < length; i++) {
                // 设定之终止符的下标，如果下标 i 和 j 字符相等，并且 i + 1 和 j - 1 位置属于回文，将 dp[i][j] 置为 1
                int j = l + i - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 中心扩展法
     * <p>
     * 观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
     * <p>
     * 所含字母数为偶数的回文的中心可以处于两字母之间“abba” 的中心在两个 ‘b’ 之间。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 考虑两种情况，aba 和 abba
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            // 取最长子串，将 start 和 end 标志取出来
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 判断回文的中心扩展法
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        // 左右移动，判断字符是否相等
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    // 第三种回文，寻找最短补充长度
    public static void addLength() {
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (judgePalindrome(arr, i, length - 1)) {
                System.out.println(length + i);
                return;
            }
        }
    }

    private static boolean judgePalindrome(char[] a, int i, int j) {
        while (i <= j) {
            if (a[i++] != a[j--]) {
                return false;
            }
        }
        return true;
    }
}
