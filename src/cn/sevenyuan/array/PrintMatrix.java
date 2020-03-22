package cn.sevenyuan.array;

import java.util.ArrayList;

/**
 *
 * 顺时针打印数组
 *
 * 思路：定义四个边界，不断收缩矩阵边界
 *
 * @author JingQ at 2020/3/22
 */
public class PrintMatrix {

    public static void main(String[] args) {

    }

    private static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        // 定义四大边界
        int up = 0, left = 0, down = matrix.length - 1, right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            // 超出上界，退出
            if (up > down) {
                break;
            }

            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (left > right) {
                break;
            }

            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (up > down) {
                break;
            }

            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return list;
    }
}
