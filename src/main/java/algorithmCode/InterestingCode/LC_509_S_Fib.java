package algorithmCode.InterestingCode;

/**
 * 509. 斐波那契数
 *
 * @author guwanli
 * @date 2022/11/23 20:00
 */
public class LC_509_S_Fib {
    public static void main(String[] args) {
        LC_509_S_Fib solution = new LC_509_S_Fib();
        int fib = solution.fib(4);
        System.out.println(fib);
    }

    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        int slow = 0, fast = 1;
        for (int i = 2; i <= n; i++) {
            int temp = slow + fast;
            slow = fast;
            fast = temp;
        }
        return fast;
    }
}
