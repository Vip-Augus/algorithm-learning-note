package cn.sevenyuan.array;

/**
 * @author JingQ at 2020/3/21
 */
public class MaxNumberOfFamilies {

    public static void main(String[] args) {
        int[][] r = new int[4][11];
        r[1][2] = 1;
        r[1][3] = 1;
        r[1][8] = 1;
        r[2][6] = 1;
        r[3][1] = 1;
        r[3][10] = 1;
        System.out.println(maxNumberOfFamilies(3, r));
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += oneLineCanHold(reservedSeats[i]);
        }
        return count;
    }

    private static int oneLineCanHold(int[] hasSat) {
        int start = 2;
        int count = 0;
        for (int i = 1; i < 10; i++) {
            if (hasSat[i] == 1) {
                if (i > 3) {
                    start++;
                }
                continue;
            }
            if (start == 2 && i == 5) {
                count++;
                start = 6;

            }

            if (start == 4 && i == 7) {
                count++;
                start = 8;
            }

            if (start == 6 && i == 9) {
                count++;
            }
        }
        return count;
    }
}
