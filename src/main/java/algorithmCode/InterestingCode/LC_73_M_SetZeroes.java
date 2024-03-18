package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 *
 * @Author bc
 * @Date 2023/6/16 23:41
 * @Description: 矩阵
 */
public class LC_73_M_SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        LC_73_M_SetZeroes solution = new LC_73_M_SetZeroes();
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean col0 = false, row0 = false;
        //判断第一列是否有0，col0做标记
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        //判断第一行是否有0，row0做标记
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }
        //第i行j列如果为0，则设置第i行第一个元素为0（标记），第j列第一个元素为零（标记）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //第i行第一个元素为0（标记），第j列第一个元素为0（标记）那么第i行j列一定为零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //判断第一列是否有0，有则设置第一列都为0
        for (int i = 0; i < m; i++) {
            if (col0) {
                matrix[i][0] = 0;
            }
        }
        //判断第一行是否有0，有则设置第一行都为0
        for (int i = 0; i < n; i++) {
            if (row0) {
                matrix[0][i] = 0;
            }
        }
    }
}
