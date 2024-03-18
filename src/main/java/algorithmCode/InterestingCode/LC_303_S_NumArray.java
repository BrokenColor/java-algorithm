package algorithmCode.InterestingCode;

/**
 * 303.区域和检索 - 数组不可变
 *
 * @Author bc
 * @Date 2024/3/18 15:33
 * @Description: 数组
 */
public class LC_303_S_NumArray {

    /**
     * 遍历计算sumRange
     */
    class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int index = left, res = 0;
            while (index <= right) {
                res += nums[index];
                index++;
            }
            return res;
        }
    }

    /**
     * 初始化，计算每个节点之前的和
     * sumRange(i,j)=sums[j+1]−sums[i]
     */
    class NumArray1 {
        int[] sum;

        public NumArray1(int[] nums) {
            int length = nums.length;
            sum = new int[length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }
}
