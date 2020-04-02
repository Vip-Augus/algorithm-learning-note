package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

/**
 * @author JingQ at 2020/3/29
 */
public class MinAndMaxWeightDistance {

    private int max = 0;
    private int min = 99999;
    private StringBuilder maxCodec;
    private StringBuilder minCodec;

    void preOrder(TreeNode T, char code, StringBuilder codec) {
        if (T == null) {
            return;
        }
        codec.append(code);
        if (T.left == null && T.right == null) {
            if (max < T.val) {
                max = T.val;
                maxCodec = codec;
            }

            if (min > T.val) {
                min = T.val;
                minCodec = codec;
            }
        }
        preOrder(T.left, '0', new StringBuilder(codec));
        preOrder(T.right, '1', new StringBuilder(codec));
    }

    public int getDirs(TreeNode root) {
        preOrder(root, '0', new StringBuilder());
        int index = 0;
        int maxDepth = Math.max(maxCodec.length(), minCodec.length());
        for (; index < maxDepth; index ++) {
            if (maxCodec.charAt(index) != minCodec.charAt(index)) {
                break;
            }
        }
        return maxCodec.substring(index).length() + minCodec.substring(index).length();
    }
}
