package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1766.互质数
 *
 * @Author bc
 * @Date 2024/4/11 23:12
 * @Description: 树
 */
public class LC_1766_H_getCoprimes {

    public static void main(String[] args) {
        LC_1766_H_getCoprimes solution = new LC_1766_H_getCoprimes();
        int[] nums = new int[]{5, 6, 10, 2, 3, 6, 15};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        System.out.println(Arrays.toString(solution.getCoprimes(nums, edges)));
    }

    List<Integer>[] gcds;
    List<Integer>[] tmp;
    List<Integer>[] g;
    int[] dep;
    int[] ans;

    /**
     * 获取与给定数组中每个数互质的数的数组。
     *
     * @param nums  给定的整数数组。
     * @param edges 表示图中节点之间关系的边的二维数组。
     * @return 一个整数数组，其中每个元素表示与nums中对应位置的数互质的最大数。
     */
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;

        // 初始化各种数据结构
        gcds = new List[51];
        tmp = new List[51];
        for (int i = 0; i <= 50; i++) {
            gcds[i] = new ArrayList<Integer>();
            tmp[i] = new ArrayList<Integer>();
        }
        ans = new int[n];
        dep = new int[n];
        Arrays.fill(ans, -1);
        Arrays.fill(dep, -1);
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        // 构建每个数的互质数列表
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) { // 如果i和j互质，则将j添加到gcds[i]中
                    gcds[i].add(j);
                }
            }
        }

        // 根据边构建图
        for (int[] val : edges) {
            g[val[0]].add(val[1]);
            g[val[1]].add(val[0]);
        }

        // 深度优先搜索，找出每个节点的最大互质数
        dfs(nums, 0, 1);

        return ans;
    }


    /**
     * 计算两个整数的最大公约数（GCD）。
     *
     * @param x 第一个整数。
     * @param y 第二个整数。
     * @return x和y的最大公约数。
     */
    public int gcd(int x, int y) {
        // 当y不等于0时，持续迭代计算最大公约数
        while (y != 0) {
            int temp = x; // 临时变量用于交换x和y的值
            x = y; // 将y的值赋给x
            y = temp % y; // 计算x对y取模的结果赋给y
        }
        return x; // 返回最终计算出的最大公约数
    }


    /**
     * 深度优先搜索函数。
     *
     * @param nums  整数数组，代表图中的节点。
     * @param x     当前遍历的节点。
     * @param depth 当前节点的深度。
     */
    public void dfs(int[] nums, int x, int depth) {
        // 设置当前节点的深度
        dep[x] = depth;
        // 遍历当前节点关联的所有节点
        for (int val : gcds[nums[x]]) {
            // 如果临时集合tmp中没有节点，跳过当前循环
            if (tmp[val].isEmpty()) {
                continue;
            }

            // 获取临时集合中最后一个节点
            int las = tmp[val].get(tmp[val].size() - 1);
            // 更新当前节点的前驱节点
            if (ans[x] == -1 || dep[las] > dep[ans[x]]) {
                ans[x] = las;
            }
        }
        // 将当前节点加入到临时集合中
        tmp[nums[x]].add(x);

        // 遍历当前节点的所有邻接节点，进行深度优先搜索
        for (int val : g[x]) {
            // 如果邻接节点未被访问过，则进行递归搜索
            if (dep[val] == -1) {
                dfs(nums, val, depth + 1);
            }
        }

        // 搜索完成后，移除当前节点 from 临时集合
        tmp[nums[x]].remove(tmp[nums[x]].size() - 1);
    }
}
