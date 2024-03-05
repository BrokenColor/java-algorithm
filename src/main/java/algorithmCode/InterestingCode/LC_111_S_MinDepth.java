package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111.二叉树的最小深度
 *
 * @author bc
 * @date 2022/12/13 19:40
 */
public class LC_111_S_MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        //遍历队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            //处理同一级的元素
            for (int i = 0; i < size; i++) {
                //队列中去一个元素
                TreeNode node = queue.poll();
                //base case
                if (node.left == null && node.right == null) return depth;

                //添加做左节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                //添加做右节点
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
