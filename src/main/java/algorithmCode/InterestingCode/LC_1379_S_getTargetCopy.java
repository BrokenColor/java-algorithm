package algorithmCode.InterestingCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1379.找出克隆二叉树中相同节点
 *
 * @Author bc
 * @Date 2024/4/3 21:29
 * @Description: 二叉树，dfs，bfs
 */
public class LC_1379_S_getTargetCopy {

    /**
     * 获取原始树中指定目标节点的克隆节点。
     *
     * @param original 原始树的根节点。
     * @param cloned   克隆树的根节点。
     * @param target   需要在原始树中查找的目标节点。
     * @return 返回目标节点在克隆树中的对应节点；如果未找到目标节点，则返回null。
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 当原始节点为空时，返回null
        if (original == null) return null;

        // 如果当前原始节点就是目标节点，则返回对应的克隆节点
        if (original == target) {
            return cloned;
        }
        // 在左子树中递归查找目标节点的克隆节点
        TreeNode node = getTargetCopy(original.left, cloned.left, target);
        // 如果在左子树中找到了目标节点的克隆节点，则直接返回该节点
        if (node != null) {
            return node;
        }
        // 如果在左子树中未找到目标节点，则在右子树中继续递归查找
        return getTargetCopy(original.right, cloned.right, target);
    }

    /**
     * 在原始树和克隆树中寻找目标节点的对应复制节点。
     *
     * @param original 原始树的根节点
     * @param cloned   克隆树的根节点
     * @param target   需要在原始树和克隆树中寻找的目标节点
     * @return 目标节点在克隆树中的对应节点；如果未找到，则返回null。
     */
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 初始化两个队列，用于层序遍历原始树和克隆树
        Queue<TreeNode> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        q1.offer(original);
        q2.offer(cloned);

        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll(), node2 = q2.poll();
            // 如果当前节点是目标节点，则返回其在克隆树中的对应节点
            if (node1 == target) {
                return node2;
            }
            // 遍历左子树
            if (node1.left != null) {
                q1.offer(node1.left);
                q2.offer(node2.left);
            }
            // 遍历右子树
            if (node2.right != null) {
                q1.offer(node1.right);
                q2.offer(node2.right);
            }
        }
        // 如果未找到目标节点，则返回null
        return null;
    }
}
