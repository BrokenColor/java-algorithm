package algorithmCode.InterestingCode;

/**
 * 27.移除元素
 *
 */
public class LC_27_S_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        LC_27_S_RemoveElement solution = new LC_27_S_RemoveElement();
        System.out.println(solution.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
