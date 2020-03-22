package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

/**
 * 是否为二叉搜索树
 *
 * @author JingQ at 3/21/20
 */
public class IsBinarySearchTree {

    public static void main(String[] args) {

    }

    private static boolean isBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 后序数组中，最后一位是 root 节点，按照 bst 的惯例，左节点都要比 root 小，右节点都要比 root 大
        int val = seq[end];
        int split = start;
        // 根据左节点性质，找出左右分割处
        while (split < end && seq[split] < val) {
            split++;
        }
        for (int i = split; i < end; i++) {
            if (seq[i] < val) {
                return false;
            }
        }
        // 不断重复切分左右子序列，判断子树是否满足后续遍历性质的 bst
        return isBST(seq, start, split - 1) && isBST(seq, split, end - 1);
    }
}
