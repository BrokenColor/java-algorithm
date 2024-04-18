package algorithmCode.InterestingCode;

/**
 * 1716. 计算力扣银行的钱
 *
 * @Author bc
 * @date 2022/1/15 13:32
 */
public class LC_1716_S_TotalMoney {
    public static void main(String[] args) {
        LC_1716_S_TotalMoney solution = new LC_1716_S_TotalMoney();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }

    /**
     * 计算给定范围内总共的钱数。该函数基于一个特定规则对数字进行累加：
     * 当前数字为1，下一个数字为前一个数字加1；每7个数字循环一次，即将当前数字加1作为下一个数字。
     *
     * @param n 给定范围的终点（包含在内）
     * @return 给定范围内按照规则累加的总钱数
     */
    public int totalMoney(int n) {
        // 当给定范围小于2时，直接返回1
        if (n < 2) return 1;

        int res = 0, p1 = 1, p2 = 1; // res为累加的结果，p1和p2为当前和下一个数字的值

        // 遍历给定范围内的所有数字
        for (int i = 1; i <= n; i++) {
            res += p2; // 将当前数字累加到结果中
            if (i % 7 == 0) {
                // 每7个数字循环一次，将当前数字加1作为下一个数字
                p2 = ++p1;
            } else {
                // 非7的倍数，下一个数字简单地加1
                p2++;
            }
        }
        return res; // 返回累加的结果
    }
}
