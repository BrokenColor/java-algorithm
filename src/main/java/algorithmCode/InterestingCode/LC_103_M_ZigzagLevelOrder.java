package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.*;

/**
 * 103.二叉树的锯齿形层序遍历
 *
 * @Author bc
 * @Date 2023/3/12 18:55
 * @Description:
 */
public class LC_103_M_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        boolean isOrderLeft = true;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(node.val);
                } else {
                    levelList.offerFirst(node.val);
                }
                //添加子节点到栈中
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            //添加结果到结果集中
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
