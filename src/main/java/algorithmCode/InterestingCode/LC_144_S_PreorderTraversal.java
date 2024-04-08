package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * @author bc
 * @date 2021/12/7 09:59
 */
public class LC_144_S_PreorderTraversal {
    public static void main(String[] args) {
        LC_144_S_PreorderTraversal sample = new LC_144_S_PreorderTraversal();

        TreeNode node = new TreeNode(1, null, null);

        System.out.println(sample.inorderTraversal(node));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    /**
     * 中序遍历二叉树的递归实现。
     *
     * @param root 二叉树的当前节点，如果为null表示遍历到叶子节点了。
     * @param res 存放遍历结果的列表，遍历过程中会将节点的值添加到这个列表中。
     */
    private void inorder(TreeNode root, List<Integer> res) {
        // 当前节点为空，直接返回，这是递归的终止条件
        if (root == null) return;
        // 遍历左子树
        res.add(root.val); // 将当前节点的值添加到结果列表中
        inorder(root.left, res); // 递归遍历左子树
        inorder(root.right, res); // 递归遍历右子树
    }
}
