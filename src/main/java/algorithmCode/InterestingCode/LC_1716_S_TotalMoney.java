package algorithmCode.InterestingCode;

/**
 * 1716. 计算力扣银行的钱
 *
 * @date 2022/1/15 13:32
 */
public class LC_1716_S_TotalMoney {
    public static void main(String[] args) {
        LC_1716_S_TotalMoney solution = new LC_1716_S_TotalMoney();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }

    public int totalMoney(int n) {
        if (n < 2) return 1;
        int res = 0, p1 = 1, p2 = 1;

        for (int i = 1; i <= n; i++) {
            res += p2;
            if (i % 7 == 0) {
                p2 = ++p1;
            } else {
                p2++;
            }
        }
        return res;
    }
}
