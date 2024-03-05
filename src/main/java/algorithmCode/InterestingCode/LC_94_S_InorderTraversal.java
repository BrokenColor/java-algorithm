package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author guwanli
 * @date 2021/12/7 09:59
 */
public class LC_94_S_InorderTraversal {
    public static void main(String[] args) {
        LC_94_S_InorderTraversal sample = new LC_94_S_InorderTraversal();

        TreeNode node = new TreeNode(1,null,null);

        System.out.println(sample.inorderTraversal(node));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
