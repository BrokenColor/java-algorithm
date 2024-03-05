package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author bc
 * @date 2022/11/22 21:04
 */
public class LC_543_S_DiameterOfBinaryTree {

    public static void main(String[] args) {
        LC_543_S_DiameterOfBinaryTree solution = new LC_543_S_DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        int result = solution.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    //最终结果
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        maxDepth(root);
        return res;
    }

    // 计算二叉树的最大深度
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = left + right;
        res = Math.max(res, myDiameter);

        return 1 + Math.max(left, right);
    }

    // 遍历二叉树
    public void traverse(TreeNode node) {
        if (node == null) return;
        // 对每个节点计算直径
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        int curDiameter = leftDepth + rightDepth;
        // 更新全局最大直径
        res = Math.max(res, curDiameter);
        //处理下一层
        traverse(node.left);
        traverse(node.right);
    }
}
