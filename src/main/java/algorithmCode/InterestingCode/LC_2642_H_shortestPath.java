package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 2642.设计可以求最短路径的图类
 *
 * @Author bc
 * @Date 2024/3/26 23:33
 * @Description: 图, 最短路径
 */
public class LC_2642_H_shortestPath {

    public static void main(String[] args) {
        LC_2642_H_shortestPath solution = new LC_2642_H_shortestPath();
        int[][] edges = {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};
        Graph graph = new Graph(4, edges);
        System.out.println(graph.shortestPath(3, 2));
        System.out.println(graph.shortestPath(0, 3));
        graph.addEdge(new int[]{1, 3, 4});
        System.out.println(graph.shortestPath(0, 3));
    }


    static class Graph {
        // 图的邻接表表示法
        private List<int[]>[] graph;

        /**
         * 构造函数，初始化图。
         *
         * @param n     图中节点的数量。
         * @param edges 图中的边，以二维数组表示，每个边包含起点、终点和边的权重。
         */
        public Graph(int n, int[][] edges) {
            graph = new List[n]; // 初始化邻接表，长度为节点数量n

            // 为每个节点创建一个空的邻接列表
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            // 遍历边数组，为每条边在邻接表中建立连接
            for (int[] edge : edges) {
                int x = edge[0]; // 边的起点
                int y = edge[1]; // 边的终点
                int cost = edge[2]; // 边的权重
                // 将终点和权重作为数组加入到起点的邻接列表中
                graph[x].add(new int[]{y, cost});
            }
        }


        /**
         * 向图中添加一条边。
         *
         * @param edge 包含边的两个顶点和边的权重的整型数组，数组的第一个元素是边的起始顶点，第二个元素是边的结束顶点，第三个元素是边的权重。
         *             例如，edge[0]和edge[1]分别表示边的起点和终点，edge[2]表示边的权重或成本。
         */
        public void addEdge(int[] edge) {
            // 获取边的起始顶点和结束顶点以及权重
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];

            // 将边添加到图的相应位置，这里使用了邻接表表示图，所以将边（y, cost）添加到顶点x的邻接表中
            graph[x].add(new int[]{y, cost});
        }

        /**
         * 计算两个节点之间的最短路径长度。
         *
         * @param node1 起始节点
         * @param node2 目标节点
         * @return 起始节点到目标节点的最短路径长度。如果不存在路径，则返回-1。
         */
        public int shortestPath(int node1, int node2) {
            // 使用优先队列存储节点和到达该节点的代价
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{node1, 0}); // 将起始节点加入队列，代价初始化为0

            // 初始化距离数组，用于记录起始节点到各个节点的最短距离
            int[] dist = new int[graph.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[node1] = 0; // 起始节点到自身的距离为0

            // 循环直到优先队列为空
            while (!pq.isEmpty()) {
                int[] arr = pq.poll(); // 出队，获取当前代价最小的节点
                int cur = arr[0]; // 当前节点
                int cost = arr[1]; // 到达当前节点的代价

                // 如果找到目标节点，返回到达目标节点的代价
                if (cur == node2) {
                    return cost;
                }

                // 遍历当前节点的所有邻居节点
                for (int[] nextArr : graph[cur]) {
                    int next = nextArr[0]; // 邻居节点
                    int nCost = nextArr[1]; // 从当前节点到邻居节点的代价
                    // 如果通过当前节点到达邻居节点的代价更小，则更新邻居节点的最短距离，并将邻居节点加入优先队列
                    if (dist[next] > cost + nCost) {
                        dist[next] = cost + nCost;
                        pq.offer(new int[]{next, cost + nCost});
                    }
                }
            }
            // 如果无法到达目标节点，返回-1
            return -1;
        }
    }
}
