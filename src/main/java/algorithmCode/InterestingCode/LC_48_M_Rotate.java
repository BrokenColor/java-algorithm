package algorithmCode.InterestingCode;

public class LC_48_M_Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        LC_48_M_Rotate solution = new LC_48_M_Rotate();
        solution.rotate(matrix);
        System.out.println(matrix);
        solution.rotate1(matrix);
        System.out.println(matrix);
    }

    /**
     * 使用新数组
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] matrix_new = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix_new[j][length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    //两次反转
    public void rotate1(int[][] matrix) {
        int length = matrix.length;
        //水平反转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }
        //对角线反转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
