package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.螺旋矩阵
 *
 * @Author bc
 * @Date 2023/3/13 12:41
 * @Description:
 */
public class LC_54_M_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int total = rows * columns;
        //记录访问过的
        Boolean[][] visible = new Boolean[rows][columns];
        //顺时针方向（右，下，左，上）
        int[][] dic = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dicIndex = 0;
        int row = 0, column = 0;
        for (int i = 0; i < total; i++) {
            //添加结果集
            res.add(matrix[row][column]);
            //标记访问过
            visible[row][column] = true;
            //计算下一个节点
            int nextRow = row + dic[dicIndex][0];
            int nextCol = column + dic[dicIndex][1];
            //判断是否需要调整方向
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns || visible[nextRow][nextCol]) {
                dicIndex = (dicIndex + 1) % 4;
            }
            //下个节点
            row += dic[dicIndex][0];
            column += dic[dicIndex][1];
        }
        return res;
    }
}
