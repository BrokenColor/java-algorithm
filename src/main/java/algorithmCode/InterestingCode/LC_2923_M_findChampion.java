package algorithmCode.InterestingCode;

/**
 * 2923.找到冠军II
 *
 * @Author bc
 * @Date 2024/4/13 18:37
 * @Description: 有向图
 */
public class LC_2923_M_findChampion {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        LC_2923_M_findChampion solution = new LC_2923_M_findChampion();
        System.out.println(solution.findChampion(n, edges));
    }

    /**
     * 查找冠军节点
     *
     * @param n     节点的数量
     * @param edges 边的数组，每个边由两个节点索引组成
     * @return 返回冠军节点的索引，如果不存在冠军节点则返回-1
     */
    public int findChampion(int n, int[][] edges) {
        // 初始化节点度数组
        int[] degree = new int[n];
        // 计算每个节点的入度
        for (int[] edge : edges) {
            degree[edge[1]]++;
        }
        // 初始化冠军节点索引为-1
        int cap = -1;
        // 查找冠军节点
        for (int i = 0; i < n; i++) {
            // 如果节点入度为0
            if (degree[i] == 0) {
                // 如果还没有找到冠军节点，则将当前节点设为冠军节点
                if (cap == -1) {
                    cap = i;
                } else {
                    // 如果已经找到一个冠军节点，说明存在多个冠军节点，返回-1
                    return -1;
                }
            }
        }
        // 返回冠军节点的索引
        return cap;
    }
}
