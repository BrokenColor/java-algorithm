package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894.所有可能的真二叉树
 *
 * @Author bc
 * @Date 2024/4/2 23:19
 * @Description: 二叉树
 */
public class LC_894_M_allPossibleFBT {
    /**
     * 生成所有可能的“非常平衡二叉树”(FBT)。非常平衡二叉树是一个二叉树，
     * 其中每个节点的值为0，且每个非叶节点恰好有一个左子节点和一个右子节点，
     * 且每个叶节点的度数为1。
     *
     * @param n 生成的FBT的节点数量，必须为奇数。
     * @return 返回一个包含所有可能的非常平衡二叉树的列表。如果n不为奇数，则返回空列表。
     */
    public List<TreeNode> allPossibleFBT(int n) {
        ArrayList<TreeNode> result = new ArrayList<>();
        // 当节点数量为偶数时，没有满足条件的FBT，直接返回空结果
        if (n % 2 == 0) return result;
        // 当节点数量为1时，只有一个可能的FBT，即空节点
        if (n == 1) {
            result.add(new TreeNode(0, null, null));
            return result;
        }
        // 递归构建所有可能的FBT
        for (int i = 1; i < n; i += 2) {
            // 通过递归构建左子树
            for (TreeNode left : allPossibleFBT(i)) {
                // 通过递归构建右子树
                for (TreeNode right : allPossibleFBT(n - 1 - i)) {
                    // 将左右子树组合成一个新的FBT
                    result.add(new TreeNode(0, left, right));
                }
            }
        }
        return result;
    }
}
