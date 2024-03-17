package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 310.最小高度树
 *
 * @Author bc
 * @Date 2024/3/17 21:05
 * @Description: dfs/bfs
 */
public class LC_310_M_FindMinHeightTrees {

    public static void main(String[] args) {
        LC_310_M_FindMinHeightTrees solution = new LC_310_M_FindMinHeightTrees();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(solution.findMinHeightTrees(n, edges));
        int n1 = 6;
        int[][] edges1 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(solution.findMinHeightTrees(n1, edges1));
    }

    /**
     * 利用广度优先搜索来找到节点的最长路径，首先找到距离节点 0 的最远节点 x，
     * 然后找到距离节点 x 的最远节点 y，然后找到节点 x 与节点 y 的路径，然后找到根节点。
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        //构建节点关联关系数组
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        //把有联系的节点存储
        for (int[] edge : edges) {
            //1->{0,2,3}
            adj[edge[0]].add(edge[1]);
            //0->{1}
            adj[edge[1]].add(edge[0]);
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* 找到与节点 0 最远的节点 x */
        int x = findMinHeightTrees(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findMinHeightTrees(x, parent, adj);
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int size = path.size();
        //路径的中间节点即为根节点
        if (size % 2 == 0) {
            ans.add(path.get(size / 2 - 1));
        }
        ans.add(path.get(size / 2));
        return ans;
    }

    /**
     * 找到与节点 u 最远的节点,并记录路径中 个节点的父节点
     *
     * @param u      要找节点
     * @param parent 记录父节点的数组
     * @param adj    点关联关系数组
     * @return
     */
    int findMinHeightTrees(int u, int[] parent, List<Integer>[] adj) {
        int n = parent.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        //记录走到节点
        int node = -1;
        queue.offer(u);
        vis[u] = true;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            //记录走到节点
            node = cur;
            for (Integer item : adj[cur]) {
                if (!vis[item]) {
                    vis[item] = true;
                    //记录当前节点为子节点的parent
                    parent[item] = cur;
                    queue.offer(item);
                }
            }
        }
        //返回最后一个处理的节点，（最远节点）
        return node;
    }
}
