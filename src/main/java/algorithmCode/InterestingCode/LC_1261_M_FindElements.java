package algorithmCode.InterestingCode;

import java.util.HashSet;

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
        recursion(root, 0);
        this.root = root;
    }

    /**
     * 递归遍历树修改节点值
     *
     * @param node
     */
    void recursion(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;

        recursion(node.left, node.val * 2 + 1);
        recursion(node.right, node.val * 2 + 2);

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
        return dfs(node.left, target) || dfs(node.right, target);
    }
}

/**
 * 使用 深度优先搜索 + 哈希表
 *
 */
class LC_1261_M_FindElements1 {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(-1, null, null);
        TreeNode node1 = new TreeNode(-1, null, null);
        TreeNode root = new TreeNode(-1, node2, node1);
        LC_1261_M_FindElements solution = new LC_1261_M_FindElements(root);
        System.out.println(solution.find(1));
        System.out.println(solution.find(2));
    }

    private HashSet<Integer> set;


    public LC_1261_M_FindElements1(TreeNode root) {
        set = new HashSet<>();
        recursion(root, 0);
    }

    /**
     * 递归遍历树修改节点值
     *
     * @param node
     */
    void recursion(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;
        set.add(val);
        recursion(node.left, node.val * 2 + 1);
        recursion(node.right, node.val * 2 + 2);

    }

    public boolean find(int target) {
        return set.contains(target);
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
