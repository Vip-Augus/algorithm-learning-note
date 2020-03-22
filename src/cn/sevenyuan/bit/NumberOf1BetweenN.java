package cn.sevenyuan.bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数
 *
 * @author JingQ at 2020/3/22
 */
public class NumberOf1BetweenN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(NumberOf1Between1AndN_Solution(n));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n < 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            // 计算在第 i 位上有多少个 1
            count += n / (10 * i) * i;
            // 不足 i 的部分，有可能存在 1
            int mod = n % (10 * i);
            if (mod > 2 * i - 1) {
                count += i;
            } else
                if (mod >= i) {
                    count += (mod - i) + 1;

            }

        }
        return count;
    }
}
