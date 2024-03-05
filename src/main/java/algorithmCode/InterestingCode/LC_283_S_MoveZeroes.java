package algorithmCode.InterestingCode;

/**
 * 283. 移动零
 *
 * @Author bc
 * @Date 2023/3/11 21:30
 * @Description: TODO
 */
public class LC_283_S_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
