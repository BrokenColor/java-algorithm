package algorithmCode.base;

/**
 * 描述：众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * @author BrokenColor
 * @date 2019年3月22日
 */
public class Mode {

	public static void main(String[] args) {
		int[] nums = {2,1,2,1,1,2,1,2,2};
		Mode mode = new Mode();
		System.out.println(mode.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		int count = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (num == nums[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					num = nums[i + 1];
				}
			}
		}
		return num;
	}
}
