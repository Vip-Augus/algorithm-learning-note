package cn.sevenyuan.string;

/**
 * 寻找最大回文，https://blog.csdn.net/zhou_209/article/details/90547718
 *
 * @author JingQ at 3/21/20
 */
public class FindLargestPalindrome {


    public static void main(String[] args) {

        System.out.println(palindrome(("dbaabe")));
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

    // 第二种高效解法
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
