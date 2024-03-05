package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author guwanli
 * @date 2022/11/22 18:20
 */
public class LC_104_S_MaxDepth {
    int res = 0, depth = 0;

    public static void main(String[] args) {
        LC_104_S_MaxDepth solution = new LC_104_S_MaxDepth();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), null);
        int i = solution.maxDepth(treeNode);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        depth++;
        if (node.left == null && node.right == null) {
            res = Math.max(res, depth);
        }
        traverse(node.left);
        traverse(node.right);
        depth--;
    }
}
