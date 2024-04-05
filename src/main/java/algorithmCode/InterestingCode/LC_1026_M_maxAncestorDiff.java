package algorithmCode.InterestingCode;

/**
 * 1026.节点与其祖先之间的最大差值
 *
 * @Author bc
 * @Date 2024/4/5 21:21
 * @Description: dfs
 */
public class LC_1026_M_maxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    /**
     * 使用深度优先搜索（DFS）遍历二叉树，找到树中任意节点值与最小值或最大值之间的差值的最大值。
     *
     * @param root 二叉树的根节点
     * @param min  当前遍历范围的最小值
     * @param max  当前遍历范围的最大值
     * @return 树中任意节点值与最小值或最大值之间的差值的最大值
     */
    private int dfs(TreeNode root, int min, int max) {
        if (root == null) { // 当前节点为空，返回0
            return 0;
        }
        // 计算当前节点值与最小值、最大值之间的差值，并更新最小值和最大值
        int diff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        // 递归遍历左子树，并更新差值的最大值
        diff = Math.max(diff, dfs(root.left, min, max));

        // 递归遍历右子树，并更新差值的最大值
        diff = Math.max(diff, dfs(root.right, min, max));

        return diff; // 返回差值的最大值
    }
}
