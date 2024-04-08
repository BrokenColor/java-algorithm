package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 2009. 使数组连续的最少操作数
 *
 * @Author bc
 * @Date 2024/4/8 23:45
 * @Description: 滑动窗口
 */
public class LC_2009_H_minOperations {

    public static void main(String[] args) {
        LC_2009_H_minOperations solution = new LC_2009_H_minOperations();
        System.out.println(solution.minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(solution.minOperations(new int[]{1, 2, 3, 5, 6}));
        System.out.println(solution.minOperations(new int[]{1, 10, 100, 1000}));
    }

    /**
     * 计算对给定数组进行最小操作次数。
     * 数组中的一个操作被定义为选择数组的一个子数组并反转它。
     * 操作的目标是使得数组中的所有元素变成相同的值。
     *
     * @param nums 给定的整数数组。
     * @return 返回执行最小操作次数后，数组中所有元素变成相同值所需的最小操作数。
     */
    public int minOperations(int[] nums) {
        int length = nums.length; // 数组长度
        Set<Integer> set = new HashSet<>(); // 用于存储数组中独特的数字
        for (int num : nums) {
            set.add(num); // 将数组中的每个数字添加到集合中
        }
        List<Integer> list = new ArrayList<>(set); // 将集合转换为列表方便排序
        Collections.sort(list); // 对列表进行排序，以便最小和最大数字易于比较
        int index = 0, res = length; // 初始化索引和结果变量
        // 遍历排序后的列表，以找到最小操作数
        for (int i = 0; i < list.size(); i++) {
            int left = list.get(i); // 当前数字
            int right = left + length - 1; // 根据当前数字和数组长度计算右边界
            // 移动索引，寻找可能的最小操作数
            while (index < list.size() && list.get(index) <= right) {
                res = Math.min(res, length - (index - i + 1)); // 更新最小操作数
                index++; // 移动索引
            }
        }
        return res; // 返回最小操作数
    }
}
