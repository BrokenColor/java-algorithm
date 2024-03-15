package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2312.卖木头块
 *
 * @Author bc
 * @Date 2024/3/15 17:14
 * @Description: 动态规划
 */
public class LC_2312_H_SellingWood {

    public static void main(String[] args) {
        int m = 3, n = 5;
        int[][] prices = {{1, 4, 2}, {2, 2, 7}, {2, 1, 3}};
        LC_2312_H_SellingWood solution = new LC_2312_H_SellingWood();
        System.out.println(solution.sellingWood(m, n, prices));
    }

    Map<Long, Integer> map;
    long[][] memo;

    public long sellingWood(int m, int n, int[][] prices) {
        //缓存h，w 对应的 价格
        map = new HashMap<>();
        for (int[] price : prices) {
            map.put(getKey(price[0], price[1]), price[2]);
        }
        //缓存中间结果，防止重复计算
        memo = new long[m + 1][n + 1];
        for (long[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dfs(m, n);
    }

    private long dfs(int x, int y) {
        //从缓存结果中找
        if (memo[x][y] != -1) return memo[x][y];

        //取出x,y的形状价格
        Long key = getKey(x, y);
        long ret = map.getOrDefault(key, 0);
        if (x > 1) {//如果x大于1，则可以继续切分，
            for (int i = 1; i <= x / 2; i++) {
                //递归切分后的价格
                long maxPrices = dfs(i, y) + dfs(x - i, y);
                //更新最大值
                ret = Math.max(ret, maxPrices);
            }
        }
        if (y > 1) {//如果y大于1，则可以继续切分
            for (int i = 1; i <= y / 2; i++) {
                //递归切分后的价格
                long maxPrices = dfs(x, i) + dfs(x, y - i);
                //更新最大值
                ret = Math.max(ret, maxPrices);
            }
        }

        // 更新缓存结果数组
        memo[x][y] = ret;
        return ret;
    }

    /**
     * 宽高做个凭借
     */
    private Long getKey(int x, int y) {
        return (long) x << 16 ^ y;
    }
}
