package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 *
 * @date 2022/1/14 10:13
 */
public class LC_373_M_KSmallestPairs {
    public static void main(String[] args) {
        LC_373_M_KSmallestPairs solution = new LC_373_M_KSmallestPairs();
        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;

//        int[] nums1 = {1, 1, 2}, nums2 = {1, 2, 3};
//        int k = 2;

//        int[] nums1 = {1, 2}, nums2 = {3};
//        int k = 3;

//        int[] nums1 = {1, 1, 2}, nums2 = {1, 2, 3};
//        int k = 10;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        //把num1中的元素依次跟num2[0] 配对添加到PriorityQueue中
        for (int i = 0; i < Math.min(k, m); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            //从PriorityQueue中 取出
            int[] poll = pq.poll();
            List<Integer> tempList = new ArrayList<>();
            tempList.add(nums1[poll[0]]);
            tempList.add(nums2[poll[1]]);
            res.add(tempList);
            //把从num2中取下一个 跟当前nums中的元素 配对添加到PriorityQueue中
            if (poll[1] + 1 < n) {
                pq.offer(new int[]{poll[0], poll[1] + 1});
            }
        }
        return res;
    }

}
