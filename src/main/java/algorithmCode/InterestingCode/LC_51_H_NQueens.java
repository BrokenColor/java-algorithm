package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 51.N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * @author bc
 * @date 2021/9/29 8:46 下午
 */
public class LC_51_H_NQueens {

    private List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        LC_51_H_NQueens leetCode51NQueens = new LC_51_H_NQueens();
        System.out.println(leetCode51NQueens.solveNQueens(n));
    }

    public List<List<String>> solveNQueens(int n) {
        List<StringBuilder> tracks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(".");
            }
            tracks.add(stringBuilder);
        }
        backtrack(tracks, 0);
        return res;
    }

    public void backtrack(List<StringBuilder> track, int row) {
        //结束条件
        if (track.size() == row) {
            List<String> strings = track.stream().map(StringBuilder::toString).collect(Collectors.toList());
            res.add(strings);
            return;
        }
//        String colStr = track.get(row);
//        char[] cols = colStr.toCharArray();
        for (int i = 0; i < track.get(row).length(); i++) {
            //判断是否有效
            if (!invalid(track, row, i)) continue;
            //添加到路径中
            track.get(row).replace(i, i + 1, "Q");
            //下一层决策
            backtrack(track, row + 1);
            //撤回选择
            track.get(row).replace(i, i + 1, ".");
        }
    }

    //判断是否有效
    private boolean invalid(List<StringBuilder> track, int row, int col) {
        int size = track.get(row).length();
        //当前列[row-1][col]
        for (int i = row; i >= 0; i--) {
            if (track.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        //左上[row-1][col-1]
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (track.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        //右上[row-1][col+1]
        for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
            if (track.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
