package algorithmCode.InterestingCode;

/**
 * 747. 至少是其他数字两倍的最大数
 *
 * @date 2022/1/13 10:12
 */
public class LC_747_S_DominantIndex {

    public static void main(String[] args) {
        LC_747_S_DominantIndex solution = new LC_747_S_DominantIndex();
        int[] nums = {3, 6, 1, 0};
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 0};
        int[] nums3 = {4, 1, 3, 1};
        System.out.println(solution.dominantIndex(nums));
        System.out.println(solution.dominantIndex(nums1));
        System.out.println(solution.dominantIndex(nums2));
        System.out.println(solution.dominantIndex(nums3));
    }

    public int dominantIndex(int[] nums) {
        if (nums.length < 2) return 0;
        //存储 最大 跟第二大的索引
        int p1 = 0, p2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[p1] < nums[i]) {
                p2 = p1;
                p1 = i;
            } else if (nums[p2] < nums[i] || p1 == p2) {
                p2 = i;
            }
        }
        return nums[p1] - nums[p2] >= nums[p2] ? p1 : -1;
    }
}
