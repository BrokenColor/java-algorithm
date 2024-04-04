package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 2192.有向无环图中一个节点的所有祖先
 *
 * @Author bc
 * @Date 2024/4/4 11:30
 * @Description: 有向图
 */
public class LC_2192_M_getAncestors {

    public static void main(String[] args) {
        LC_2192_M_getAncestors solution = new LC_2192_M_getAncestors();
        int n = 8;
        int[][] edgeList = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        //[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
        System.out.println(solution.getAncestors(n, edgeList));
    }

    /**
     * 获取给定节点的祖先集合。
     *
     * @param n     节点的数量。
     * @param edges 表示节点之间关系的边的数组，每个边由两个节点组成。
     * @return 一个列表的列表，每个子列表表示给定节点的所有祖先节点，按升序排列。
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 初始化父节点集合和节点关系数组
        Set<Integer>[] anc = new Set[n];
        List<Integer>[] listArr = new List[n];
        for (int i = 0; i < n; i++) {
            anc[i] = new HashSet<>();
            listArr[i] = new ArrayList<>();
        }

        // 计算节点的入度
        int[] inEdges = new int[n];
        for (int[] edge : edges) {
            listArr[edge[0]].add(edge[1]); // 添加关系
            inEdges[edge[1]]++; // 增加目标节点的入度
        }

        // 使用队列来进行拓扑排序
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inEdges.length; i++) {
            if (inEdges[i] == 0) {
                deque.offer(i); // 入度为0的节点入队
            }
        }

        // 拓扑排序核心逻辑
        while (!deque.isEmpty()) {
            Integer cur = deque.pop(); // 取出当前节点
            for (Integer next : listArr[cur]) { // 遍历当前节点的所有子节点
                anc[next].add(cur); // 添加当前节点作为子节点的父节点
                anc[next].addAll(anc[cur]); // 添加当前节点的所有父节点作为子节点的父节点
                inEdges[next]--; // 子节点的入度减1
                if (inEdges[next] == 0) { // 如果子节点入度为0，入队
                    deque.offer(next);
                }
            }
        }

        // 处理结果，转换为列表形式并排序
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>(anc[i]));
            Collections.sort(result.get(i)); // 对每个祖先集合进行排序
        }
        return result;
    }
}
