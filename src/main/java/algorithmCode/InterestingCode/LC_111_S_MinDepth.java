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
    /**
     * 计算二叉树的最小深度。
     *
     * @param root 二叉树的根节点
     * @return 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        // 如果根节点为空，返回深度0
        if (root == null) return 0;
        // 使用队列来进行层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; // 当前深度初始化为1

        // 遍历队列，直到队列为空
        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的节点数量

            // 处理当前层的所有节点
            for (int i = 0; i < size; i++) {
                // 出队一个节点
                TreeNode node = queue.poll();
                // 当前节点为叶子节点时，返回当前深度
                if (node.left == null && node.right == null) return depth;

                // 当前节点有左子节点时，入队左子节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 当前节点有右子节点时，入队右子节点
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++; // 深度加1，进入下一层
        }
        return depth;
    }
}
