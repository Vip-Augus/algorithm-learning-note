package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

/**
 * @author JingQ at 2020/3/23
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
