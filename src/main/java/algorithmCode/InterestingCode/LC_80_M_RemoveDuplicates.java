package algorithmCode.InterestingCode;

/**
 * 80.删除排序数组中的重复项 II
 *
 * @Author bc
 * @Date 2023/5/7 10:58
 * @Description: TODO
 */
public class LC_80_M_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int slow = 2, fast = 2;
        while (fast < length) {
            //与两步之前的比较，不相同则覆盖
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
