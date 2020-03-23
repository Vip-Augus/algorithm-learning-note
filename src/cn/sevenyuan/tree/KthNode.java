package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k个结点
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 思路，使用中序遍历，left -> root -> right，排完序后，取 k - 1
 * @author JingQ at 3/21/20
 */
public class KthNode {

    private ArrayList<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    private TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        addNode(pRoot);
        if (k >= 1 && k <= list.size()) {
            return list.get(k - 1);
        }
        return null;
    }

    /**
     * 中序遍历，将节点添加到 list 中
     * @param node  节点
     */
    private void addNode(TreeNode node) {
        if (node == null) {
            return;
        }
        addNode(node.left);
        list.add(node);
        addNode(node.right);
    }
}
