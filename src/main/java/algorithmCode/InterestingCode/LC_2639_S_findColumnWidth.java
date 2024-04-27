package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 2639. 查询网格图中每一列的宽度
 *
 * @Author bc
 * @Date 2024/4/27 20:57
 * @Description: 数组
 */
public class LC_2639_S_findColumnWidth {

    public static void main(String[] args) {
        LC_2639_S_findColumnWidth solution = new LC_2639_S_findColumnWidth();
        int[][] grid = {{1}, {22}, {333}};
        System.out.println(Arrays.toString(solution.findColumnWidth(grid)));
    }

    /**
     * 查找二维数组中每一列的最大宽度。
     *
     * @param grid 一个包含数字的二维数组，代表要查找宽度的表格。
     * @return 一个整型数组，其中每个元素表示相应列中数字字符串的最大长度。
     */
    public int[] findColumnWidth(int[][] grid) {
        // 获取二维数组的列数
        int n = grid[0].length;
        // 初始化一个整型数组用于存储每列的最大宽度
        int[] ans = new int[n];
        // 遍历二维数组的所有行
        for (int i = 0; i < grid.length; i++) {
            // 遍历当前行的所有列，计算并更新每列的最大宽度
            for (int j = 0; j < grid[i].length; j++) {
                // 使用当前元素的字符串长度与当前列的最大宽度比较，取较大值
                ans[j] = Math.max(ans[j], String.valueOf(grid[i][j]).length());
            }
        }
        // 返回包含每列最大宽度的数组
        return ans;
    }
}
