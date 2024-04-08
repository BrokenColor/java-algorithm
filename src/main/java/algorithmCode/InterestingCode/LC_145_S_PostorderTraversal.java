package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *
 * @author bc
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

    /**
     * 以递归方式对二叉树进行中序遍历，将遍历结果存储到一个列表中。
     *
     * @param root 二叉树的根节点
     * @param res 存储遍历结果的列表
     */
    private void inorder(TreeNode root, List<Integer> res) {
        // 如果当前节点为空，直接返回
        if (root == null) return;
        // 遍历左子树
        inorder(root.left, res);
        // 遍历右子树
        inorder(root.right, res);
        // 将当前节点的值添加到结果列表中
        res.add(root.val);
    }
}
