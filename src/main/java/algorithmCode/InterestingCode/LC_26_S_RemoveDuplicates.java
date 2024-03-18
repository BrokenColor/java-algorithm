package algorithmCode.InterestingCode;

/**
 * 26.删除有序数组中的重复项
 *
 * @author bc
 * @date 2022/11/22 16:00
 */
public class LC_26_S_RemoveDuplicates {

    public static void main(String[] args) {
        LC_26_S_RemoveDuplicates solution = new LC_26_S_RemoveDuplicates();
        int[] nums = {2, 2, 3, 4, 5, 6};
        int i = solution.removeDuplicates(nums);
        int i1= solution.removeDuplicates1(nums);
        System.out.println(i);
        System.out.println(i1);
    }

    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                //维护 nums[0..i] 无重复
                nums[i] = nums[j];
            }
        }
        // 数组长度为索引 + 1
        return i + 1;

    }

    public int removeDuplicates1(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
