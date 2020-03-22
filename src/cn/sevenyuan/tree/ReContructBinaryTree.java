package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author JingQ at 2020/3/23
 */
public class ReContructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(pre[0]);
        // 在中序中找到前序的根节点
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 分别找到左右节点，copyOfRange 函数是左闭右开
                rootNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1)
                        , Arrays.copyOfRange(in, 0, i));
                rootNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length)
                        , Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return rootNode;
    }
}
