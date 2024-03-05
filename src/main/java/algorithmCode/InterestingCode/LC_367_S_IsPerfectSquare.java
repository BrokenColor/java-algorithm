package algorithmCode.InterestingCode;

/**
 * 367. 有效的完全平方数
 *
 * @author guwanli
 * @date 2021/12/22 19:36
 */
public class LC_367_S_IsPerfectSquare {
    public static void main(String[] args) {
        LC_367_S_IsPerfectSquare solution = new LC_367_S_IsPerfectSquare();
        System.out.println(solution.isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 0, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long res = (long) mid * mid;
            if (res == num) {
                return true;
            } else if (res > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
