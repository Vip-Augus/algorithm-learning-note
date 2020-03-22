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
}
