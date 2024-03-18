package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

/**
 * 98.验证二叉搜索树
 *
 * @author bc
 * @date 2021/12/9 10:52
 */
public class LC_98_M_IsValidBST {

    public static void main(String[] args) {
        LC_98_M_IsValidBST solution = new LC_98_M_IsValidBST();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(solution.isValidBST((root)));
    }

    int pre = Integer.MIN_VALUE;

    //中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //判断是否小于前一节点
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        //右子树
        return isValidBST(root.right);
    }

}
