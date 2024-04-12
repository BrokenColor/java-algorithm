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
     * 判断给定的整数是否是一个"快乐数"。
     * "快乐数"定义如下：对于给定的正整数n，通过以下规则不断计算新的数值，直到计算结果为1或者之前出现过的数。
     * 计算规则：将n的各个数字的平方和作为新的数值。
     * 如果最终计算结果为1，则认为n是"快乐数"；如果出现循环，即计算结果之前已经出现过，则认为n不是"快乐数"。
     *
     * @param n 需要判断的正整数
     * @return 返回true如果给定的数是"快乐数"，否则返回false
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet(); // 使用HashSet记录计算过程中出现的数值，避免循环
        while (n != 1 && !set.contains(n)) {
            set.add(n); // 将当前数值加入HashSet中
            n = getNext(n); // 计算下一个数值
        }
        return n == 1; // 如果最终结果为1，则是"快乐数"，返回true，否则返回false
    }

    /**
     * 计算给定整数的下一个数值。
     * 根据"快乐数"的计算规则，将给定整数n的各个数字的平方和作为新的数值返回。
     *
     * @param n 给定的整数
     * @return 返回n的下一个计算数值
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // 获取n的最后一位数字
            sum += digit * digit; // 将最后一位数字的平方加到总和上
            n /= 10; // 去掉n的最后一位数字
        }
        return sum;
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
