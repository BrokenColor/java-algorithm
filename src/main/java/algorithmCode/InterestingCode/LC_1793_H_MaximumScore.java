package algorithmCode.InterestingCode;

/**
 * 1793. 好子数组的最大分数
 *
 * @Author bc
 * @Date 2024/3/19 12:38
 * @Description:
 */
public class LC_1793_H_MaximumScore {

    public static void main(String[] args) {
        LC_1793_H_MaximumScore solution = new LC_1793_H_MaximumScore();
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;
        System.out.println(solution.maximumScore(nums, k));
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k - 1, right = k + 1, ans = 0;
        //遍历nums[k]到1，
        for (int i = nums[k]; i > 0; i--) {
            //向左遍历 找到左侧第一个比nums[k]小的数
            while (left >= 0 && nums[left] >= i) {
                left--;
            }
            //向右遍历 找到右侧第一个比nums[k]小的数
            while (right < n && nums[right] >= i) {
                right++;
            }
            //更新结果
            ans = Math.max(ans, i * (right - left - 1));
            //如果左右都遍历完了，结束循环
            if (left < 0 && right >= n) {
                break;
            }
        }
        return ans;
    }
}
