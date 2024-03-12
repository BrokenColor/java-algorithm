package algorithmCode.InterestingCode;

/**
 * 1261.在受污染的二叉树中查找元素
 *
 * @Author bc
 * @Date 2024/3/12 11:26
 * @Description: dfs
 */
public class LC_1261_M_FindElements {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(-1, null, null);
        TreeNode node1 = new TreeNode(-1, null, null);
        TreeNode root = new TreeNode(-1, node2, node1);
        LC_1261_M_FindElements solution = new LC_1261_M_FindElements(root);
        System.out.println(solution.find(1));
        System.out.println(solution.find(2));
    }

    private TreeNode root;

    public LC_1261_M_FindElements(TreeNode root) {
        root.val = 0;
        recursion(root);
        this.root = root;
    }

    /**
     * 递归遍历树修改节点值
     * @param root
     */
    void recursion(TreeNode root) {
        if (root.left == null && root.right == null) return;
        if (root.left != null) {
            root.left.val = (root.val * 2) + 1;
            recursion(root.left);
        }
        if (root.right != null) {
            root.right.val = (root.val * 2) + 2;
            recursion(root.right);
        }
    }

    public boolean find(int target) {
        return dfs(root, target);
    }

    //深度优先遍历
    boolean dfs(TreeNode node, int target) {
        //到根结点说明没找到 返回false
        if (node == null) return false;
        //判断是否目标值
        if (node.val == target) return true;
        return  dfs(node.left, target) || dfs(node.right, target);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
