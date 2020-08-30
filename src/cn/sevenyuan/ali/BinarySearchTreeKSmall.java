package cn.sevenyuan.ali;

import cn.sevenyuan.base.TreeNode;

/**
 * 寻找树中第 k 小的节点
 *
 * 树相关的题目，第一眼就想到递归求解，
 * a)左右子树分别遍历。
 * b)联想到二叉搜索树的性质，root 大于左子树，小于右子树，
 * c)如果左子树的节点数目等于 K-1，那么 root 就是结果，
 * d)否则如果左子树节点数目小于 K-1，那么结果必然在右子树，
 * e)否则就在左子树。因此在搜索的时候同时返回节点数目，跟 K 做对比，就能得出结果了。
 * @author JingQ at 8/30/20
 */
public class BinarySearchTreeKSmall {

    public static void main(String[] args) {
        /**
         *        5
         *       / \
         *      3   6
         *     / \
         *    2   4
         *   /
         *  1
         */
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;


        System.out.println(findK(node1, 3).val);
    }

    private static class ResultType {
        private boolean found;
        private int val;

        ResultType(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }

    private static ResultType findK(TreeNode rootNode, int k) {
        if (rootNode == null) {
            return new ResultType(false, 0);
        }

        ResultType left = findK(rootNode.left, k);

        // 左子树找到，直接返回
        if (left.found) {
            return new ResultType(true, left.val);
        }

        // 如果 k - left.val == 1，表示自己本身就是第 k 小的值
        if (k - left.val == 1) {
            return new ResultType(true, rootNode.val);
        }

        // 从右子树寻找
        ResultType right = findK(rootNode.right, k - left.val - 1);
        if (right.found) {
            return new ResultType(true, right.val);
        }
        // 都没找到，返回该节点的子节点总个数
        return new ResultType(false, left.val + right.val + 1);
    }
}
