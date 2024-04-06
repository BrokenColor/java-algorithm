package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 1483. 树节点的第 K 个祖先
 *
 * @Author bc
 * @Date 2024/4/6 10:53
 * @Description: TODO
 */
public class LC_1483_H_TreeAncestor {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6};
        TreeAncestor treeAncestor = new TreeAncestor(22, parent);
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
        System.out.println(treeAncestor.getKthAncestor(7, 3));
        System.out.println(treeAncestor.getKthAncestor(12, 3));
    }
}

class TreeAncestor {
    private final int LOG = 16;
    private int[][] ancestors;

    /**
     * 构造一个树的祖先数组。
     * 树的每个节点都有一个唯一的标识符，从0到n-1。
     * 给定每个节点的父节点数组，这个构造函数计算并存储每个节点的每个祖先节点。
     * 具体来说，对于每个节点i，ancestors[i]是一个数组，其中ancestors[i][j]是i的2^j个祖先。
     * 参数:
     * n - 树中节点的数量。
     * parent - 一个整数数组，parent[i]表示节点i的父节点的标识符。数组的长度是n。
     */
    public TreeAncestor(int n, int[] parent) {
        // 初始化存储祖先的二维数组
        ancestors = new int[n][LOG];
        // 填充数组，每个节点的直接父节点已知
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestors[i], -1); // 除直接父节点外，初始化为-1
            ancestors[i][0] = parent[i]; // 设置直接父节点
        }
        // 通过迭代填充祖先数组，以计算每个节点的更高层次祖先
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                // 如果节点i的2^(j-1)个祖先已知，则计算其2^j个祖先
                if (ancestors[i][j - 1] != -1) {
                    //节点i的2^j的祖先
                    ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
                }
            }
        }
    }

    /**
     * 获取指定节点的第k个祖先节点
     *
     * @param node 指定的节点
     * @param k    想要获取的祖先节点的级别
     * @return 返回第k个祖先节点的值，如果不存在则返回-1
     */
    public int getKthAncestor(int node, int k) {
        //逻辑：把k 拆解成（2^a+2^b+...） 即：k祖先节点是 从 node的祖先node1（2^a）再到祖先 node2（2^b）。。。到祖先nodeK（k）
        // 遍历祖先数组，通过位运算判断是否需要跳转到下一个祖先节点
        for (int i = 0; i < LOG; i++) {
            // 判断当前位是否为1，若为1则表示需要访问该祖先节点
            if (((k >> i) & 1) != 0) {
                node = ancestors[node][i]; // 跳转到下一个祖先节点
                if (node == -1) {
                    return -1; // 如果祖先节点为-1，表示不存在该祖先节点
                }
            }
        }
        return node; // 返回第k个祖先节点
    }
}
