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

    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int length = coins.length;
        int sum = 1, index = 0, ans = 0;
        while (sum <= target) {
            if (index < length && coins[index] <= sum) {
                sum += coins[index];
                index++;
            } else {
                sum *= 2;
                ans++;
            }
        }
        return ans;
    }

}
