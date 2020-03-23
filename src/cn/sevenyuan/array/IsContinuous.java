package cn.sevenyuan.array;

import java.util.TreeSet;

/**
 * @author JingQ at 2020/3/23
 */
public class IsContinuous {


    public boolean isContinuous(int [] n) {
        if (n.length != 5) {
            return false;
        }
        int num = 0;
        TreeSet<Integer> set = new TreeSet<> ();
        for (int i=0; i<n.length;i++) {
            if (n[i]==0) {
                num ++;
            } else {
                set.add(n[i]);
            }
        }
        if ((num + set.size()) != 5) {
            return false;
        }
        if ((set.last() - set.first()) < 5) {
            return true;
        }
        return false;
    }
}
