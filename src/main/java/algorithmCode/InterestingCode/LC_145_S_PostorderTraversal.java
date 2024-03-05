package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *
 * @author guwanli
 * @date 2021/12/7 09:59
 */
public class LC_145_S_PostorderTraversal {
    public static void main(String[] args) {
        LC_145_S_PostorderTraversal sample = new LC_145_S_PostorderTraversal();

        TreeNode node = new TreeNode(1, null, null);

        System.out.println(sample.inorderTraversal(node));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    //递归方式处理
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        inorder(root.right, res);
        res.add(root.val);
    }
}
