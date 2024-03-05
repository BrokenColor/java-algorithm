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

    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
//                多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
                if (count == 0) {
                    num = nums[i + 1];
                }
            }
        }
        return num;
    }
}
