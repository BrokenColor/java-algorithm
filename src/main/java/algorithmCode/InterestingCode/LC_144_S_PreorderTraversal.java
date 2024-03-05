package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * @author guwanli
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

    //递归方式处理
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        inorder(root.left, res);
        inorder(root.right, res);
    }
}
