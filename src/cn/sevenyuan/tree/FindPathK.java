package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

import java.util.ArrayList;

/**
 *
 * 寻找节点值与 target 一致的路径
 *
 * @author JingQ at 2020/3/22
 */
public class FindPathK {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();


    private ArrayList findPath(TreeNode root, int k) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        k -= root.val;
        // 完整的路径是从 根节点到末尾节点
        if (k == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        findPath(root.left, k);
        findPath(root.right, k);
        list.remove(list.size() - 1);
        return result;
    }

    private void delete(int data) {
        TreeNode root = new TreeNode(10);
        // 标记为要删除的节点
        TreeNode p = root;
        // 被删除节点的父节点
        TreeNode pp = null;
        // 寻找要被删除的节点
        while(p != null && p.val != data) {
            pp = p;
            if (p.val > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            // 边界值，表示没有找到
            return;
        }

        // 如果左右节点都有值，需要找到删除节点右分支最下面的左分支
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP.left != null) {
                minP = minP.left;
                minPP = minP;
            }
            // 将 minP 的值替换到 p 上，这样被删除的节点就变成了 minP
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }

        // 删除的节点只剩一个节点
        TreeNode child = null;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }

        if (pp == null) {
            // 表示要删除的是 根节点
            root = null;
        } else if (pp.left == p) {
            pp.left = child;
        } else if (pp.right == p) {
            pp.right = child;
        }
    }
}
