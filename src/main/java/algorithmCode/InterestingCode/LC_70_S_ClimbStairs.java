package algorithmCode.InterestingCode;

/**
 * 70.爬楼梯
 *
 * @author guwanli
 * @date 2021/12/3 17:48
 */
public class LC_70_S_ClimbStairs {
    static int[] cache;

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        System.out.println(dp(45));
    }

    public static int climbStairs(int n) {
        cache = new int[n + 1];
        //递归
        return recursion(n);
    }

    //递归处理
    private static int recursion(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (cache[n] != 0) return cache[n];
        int result = recursion(n - 1) + recursion(n - 2);
        cache[n] = result;
        return result;
    }

    //三个变量
    private static int dp(int n) {
        int a1 = 0, a2 = 1, a3 = 2;
        for (int i = 1; i <= n; i++) {
            a3 = a1 + a2;
            a1 = a2;
            a2 = a3;
        }
        return a3;
    }

}
