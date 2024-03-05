package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * @Author bc
 * @Date 2024/2/26 18:05
 * @Description: BFS
 */
public class LC_515_M_LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            //遍历当前行的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxValue = Math.max(node.val, maxValue);
                //添加下一节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}
