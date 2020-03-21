package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：递归寻找节点的左右高度，两者高度差大于 1 表示不是平衡二叉树
 *
 * @author JingQ at 3/21/20
 */
public class IsBalancedTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        boolean isBalanced = depth(node) != -1;
        System.out.println(isBalanced);
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            //表示到达了末尾节点
            return 0;
        }
        int left = depth(node.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
