package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 2952.需要添加的硬币的最小数量
 *
 * @Author bc
 * @Date 2024/3/30 19:38
 * @Description: 贪心
 */
public class LC_2952_M_minimumAddedCoins {
    public static void main(String[] args) {
        LC_2952_M_minimumAddedCoins solution = new LC_2952_M_minimumAddedCoins();
        System.out.println(solution.minimumAddedCoins(new int[]{1, 4, 10}, 19));
        System.out.println(solution.minimumAddedCoins(new int[]{1, 4, 10, 5, 7, 19}, 19));
    }

    /**
     * 计算达到目标金额所需的最小额外硬币数。
     * 首先对硬币进行排序，然后通过逐步增加硬币的面额来逼近目标金额。
     * 如果当前和小于或等于目标金额，就加入下一个面额最小的硬币；
     * 否则，将当前和翻倍，并增加所需的额外硬币数。
     *
     * @param coins 包含不同面额硬币的数组，已排序。
     * @param target 目标金额。
     * @return 达到目标金额所需的最小额外硬币数。
     */
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);  // 对硬币进行排序
        int length = coins.length;
        int sum = 1, index = 0, ans = 0;  // 初始化当前和、硬币索引和额外硬币数

        while (sum <= target) {  // 当当前和不超过目标金额时循环
            if (index < length && coins[index] <= sum) {  // 如果还有硬币且硬币面额小于等于当前和
                sum += coins[index];  // 加入该硬币
                index++;  // 移动到下一个硬币
            } else {  // 否则，当前和需要翻倍，并记录需要额外的硬币
                sum *= 2;
                ans++;
            }
        }
        return ans;  // 返回额外硬币数
    }

}
