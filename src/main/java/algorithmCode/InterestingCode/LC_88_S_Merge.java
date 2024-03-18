package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 *
 */
public class LC_88_S_Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        LC_88_S_Merge solution = new LC_88_S_Merge();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 倒叙遍历num2数组中元素，跟num1中最大比较，大的移动到队尾
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = nums1.length - 1, index = n - 1;
        while (left <= right && index >= 0) {
            //nums1队尾（最大）与nums2队尾（最大）比较大小
            if (left >= 0 && nums1[left] > nums2[index]) {
                nums1[right] =nums1[left];
                left--;
            }else{
                nums1[right] =nums2[index];
                index--;
            }
            right--;
        }
    }
}
