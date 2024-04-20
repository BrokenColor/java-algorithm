package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 1883. 准时抵达会议现场的最小跳过休息次数
 *
 * @Author bc
 * @Date 2024/4/20 13:22
 * @Description: 动态规划
 */
public class LC_1883_H_minSkips {

    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        int speed = 4, hoursBefore = 2;
        LC_1883_H_minSkips solution = new LC_1883_H_minSkips();
        System.out.println(solution.minSkips(dist, speed, hoursBefore));
    }

    private final double ESP = 1e-7;
    private final double INFTY = 1e20;

    /**
     * 计算在给定速度和时间限制下，最少需要跳过多少个距离点才能在指定时间内完成整个路程。
     *
     * @param dist        路程中的距离数组，dist[i] 表示从起点到第 i 个点的距离。
     * @param speed       行进速度，单位为距离/时间。
     * @param hoursBefore 允许的剩余时间，即在多少时间内必须完成整个路程。
     * @return 最少需要跳过的点的数量。如果无法在规定时间内完成整个路程，则返回 -1。
     */
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        double[][] f = new double[n + 1][n + 1]; // 动态规划数组，f[i][j] 表示到达第 i 个点最少需要跳过 j 次的距离。
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], INFTY); // 初始化动态规划数组，设置为无穷大，表示初始情况下无法到达任何点。
        }
        f[0][0] = 0; // 起点不需要跳过任何点。

        // 动态规划计算最少跳过次数。
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                // 当前点不跳过，考虑从上一个点到达当前点的时间。
                if (i != j) {
                    f[i][j] = Math.min(f[i][j], Math.ceil(f[i - 1][j] + (double) dist[i - 1] / speed - ESP));
                }
                // 当前点跳过，考虑从上一个点到达当前点的时间。
                if (j != 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + (double) dist[i - 1] / speed);
                }
            }
        }

        // 查找能在规定时间内完成的最少跳过次数。
        for (int i = 0; i <= n; i++) {
            if (f[n][i] < hoursBefore + ESP) {
                return i;
            }
        }
        return -1; // 无法在规定时间内完成整个路程。
    }
}
