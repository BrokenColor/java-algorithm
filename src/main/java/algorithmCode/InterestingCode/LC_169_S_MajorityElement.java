package algorithmCode.InterestingCode;

/**
 * 169. 多数元素
 *
 * @author bc
 * @date 2023/5/10 19:31
 */
public class LC_169_S_MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {3, 3, 4};
        LC_169_S_MajorityElement solution = new LC_169_S_MajorityElement();
        System.out.println(solution.majorityElement(nums));
    }

/**
 * 寻找数组中的多数元素
 * 多数元素是指在数组中出现次数大于⌊n/2⌋的元素（其中n为数组长度）。
 *
 * @param nums 包含整数的数组
 * @return 数组中的多数元素
 */
public int majorityElement(int[] nums) {
    int count = 1; // 初始化计数器
    int num = nums[0]; // 以数组第一个元素为初始候选多数元素
    for (int i = 1; i < nums.length; i++) {
        if (num == nums[i]) {
            count++; // 如果当前元素与候选多数元素相同，则计数器增加
        } else {
            count--; // 如果当前元素与候选多数元素不同，则计数器减少
            // 当计数器减为0时，更新候选多数元素为当前元素
            if (count == 0) {
                num = nums[i + 1];
            }
        }
    }
    return num; // 返回候选多数元素作为结果
}

}
