package cn.sevenyuan.queue;

import cn.sevenyuan.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 按层遍历树
 *
 * @author JingQ at 2021/5/25
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 生成 FIFO 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        if (root != null) {
            queue.offer(root);
        }
        List<List<Integer>> ans = new ArrayList<>();
        // 开始利用 FIFO 队列进行层次遍历
        while (queue.size() > 0) {
            // 取出当前层有多少个节点
            int queueSize = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                // 前面的节点先出队
                TreeNode cur = queue.poll();
                // 将结果放入当前层中
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 将当前层结果放入最终结果集中
            ans.add(tmp);
        }
        return ans;
    }

}
