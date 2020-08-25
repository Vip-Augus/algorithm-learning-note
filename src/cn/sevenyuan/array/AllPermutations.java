package cn.sevenyuan.array;

/**
 * 全排列
 *
 * @author JingQ at 2020/8/24
 */
public class AllPermutations {

    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            // 来到了最后一个
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            printPermutations(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] {1, 2, 3};
        printPermutations(data, 3, 3);
    }
}
