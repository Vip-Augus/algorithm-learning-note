package cn.sevenyuan.tree;

import cn.sevenyuan.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JingQ at 2020/3/23
 */
public class DistantK {

    private List<Integer> ans;
    private TreeNode target;
    private int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        } else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) {
                    ans.add(node.val);
                }
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) {
                    ans.add(node.val);
                }
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }


    public void subtree_add(TreeNode node, int dist) {
        if (node == null) {
            return;
        }
        if (dist == K) {
            ans.add(node.val);
        } else {
            subtree_add(node.left, dist  + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}
