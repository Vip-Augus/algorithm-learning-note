package cn.sevenyuan.dynamicprogramming;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author JingQ at 2020/4/18
 */
public class MinimumPath {

    public static void main(String[] args) {
        List<List<Integer>> triangle = Lists.newArrayList();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3,4));
        triangle.add(Lists.newArrayList(6,5,7));
        triangle.add(Lists.newArrayList(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = n - 1; i >= 1; i--) {
            List<Integer> tempList = triangle.get(i - 1);
            List<Integer> nextList = triangle.get(i);
            int tempListSize = tempList.size();
            for (int j = 0; j < tempListSize; j++) {
                int temp = tempList.get(0);
                int minPath = Math.min(temp + nextList.get(j), temp + nextList.get(j+1));
                tempList.remove(0);
                tempList.add(minPath);
            }
        }
        return triangle.get(0).get(0);
    }

}
