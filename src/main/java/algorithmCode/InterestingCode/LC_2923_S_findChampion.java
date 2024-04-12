package algorithmCode.InterestingCode;

/**
 * 2923.找到冠军
 *
 * @Author bc
 * @Date 2024/4/12 22:39
 * @Description: 数组
 */
public class LC_2923_S_findChampion {
    public static void main(String[] args) {
        LC_2923_S_findChampion solution = new LC_2923_S_findChampion();
        System.out.println(solution.findChampion(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(solution.findChampion1(new int[][]{{0, 1}, {0, 0}}));
    }

    /**
     * 在给定的二维网格中寻找冠军。
     * 网格中的每个单元格包含一个非负整数，且网格的行数和列数相等。
     * 冠军是指在它的行和列中，只有一个单元格包含1，而其它单元格都包含0。
     * 如果存在冠军，则返回其行索引；如果不存在，则返回-1。
     *
     * @param grid 二维网格，包含非负整数。
     * @return 如果存在冠军，则返回冠军的行索引；否则返回-1。
     */
    public int findChampion(int[][] grid) {
        int n = grid.length;
        // 遍历每一行，查找可能的冠军
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 统计当前行以外的1的个数
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    sum++;
                }
            }
            // 如果当前行以外的1的个数等于总行数减1，则当前行是冠军
            if (sum == n - 1) {
                return i;
            }
        }
        // 如果没有找到冠军，返回-1
        return -1;
    }

    /**
     * 在给定的二维网格中寻找“冠军”单元格的索引。
     * 网格中每个单元格包含一个非负整数。初始时，“冠军”单元格被假定为网格的第一个单元格。
     * 如果当前“冠军”单元格的值是1，则保持其为“冠军”；否则，更新“冠军”为下一个具有值为1的单元格。
     * 如果不存在值为1的单元格，则当前“冠军”保持不变。
     *
     * @param grid 二维整数网格，表示比赛的当前状态。
     * @return 返回当前“冠军”单元格的索引。
     */
    public int findChampion1(int[][] grid) {
        int n = grid.length; // 网格的行数
        int cap = 0; // 当前“冠军”单元格的索引
        for (int i = 1; i < n; i++) { // 遍历网格，从第二行开始
            if (grid[i][cap] == 1) { // 如果当前行的“冠军”单元格值为1
                cap = i; // 更新“冠军”索引
            }
        }
        return cap; // 返回最终的“冠军”单元格索引
    }
}
