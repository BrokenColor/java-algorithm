package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 202.快乐数
 * 判断是否有环
 */
public class LC_202_S_IsHappy {

    public static void main(String[] args) {
        LC_202_S_IsHappy solution = new LC_202_S_IsHappy();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy1(19));
        System.out.println(solution.isHappy2(19));
    }

    /**
     * set集合判断是否访问过
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalsum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalsum += d * d;
        }
        return totalsum;
    }

    /**
     * 快慢指针
     *
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    /**
     * 哈希表
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        //只有一个环
        Set<Integer> cycleMembers = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }
}
