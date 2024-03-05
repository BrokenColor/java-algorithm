package algorithmCode.InterestingCode;

import java.util.Arrays;
/**
 * 452. 用最小数量的箭引爆气球
 *
 * @date 2023/7/31 15:24
 */
public class LC_452_S_findMinArrowShots {
    public static void main(String[] args) {
        LC_452_S_findMinArrowShots solution = new LC_452_S_findMinArrowShots();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = solution.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] > point2[1]) {
                return 1;
            } else if (point1[1] < point2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
