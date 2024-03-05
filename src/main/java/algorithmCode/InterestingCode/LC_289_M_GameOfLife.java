package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 289. 生命游戏
 */
public class LC_289_M_GameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        LC_289_M_GameOfLife solution = new LC_289_M_GameOfLife();
//        solution.gameOfLife(board);
        solution.gameOfLife1(board);
        System.out.println(Arrays.deepToString(board));
    }

    /**
     * 复制数组
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[] neighbors = {0, 1, -1};

        int[][] board_copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board_copy[i][j] = board[i][j];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int neighborsLive = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (neighbors[i] == 0 && neighbors[j] == 0) {
                            continue;
                        }
                        int r = row + neighbors[i];
                        int c = col + neighbors[j];
                        if (r >= 0 && r < rows && c >= 0 && c < cols && board_copy[r][c] == 1) {
                            neighborsLive++;
                        }
                    }
                }

                if (board_copy[row][col] == 1 && (neighborsLive < 2 || neighborsLive > 3)) {
                    board[row][col] = 0;
                } else if (board_copy[row][col] == 0 && neighborsLive == 3) {
                    board[row][col] = 1;
                }

            }
        }
    }

    /**
     * 原数组上处理
     *
     * @param board
     */
    public void gameOfLife1(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[] neighbors = {0, 1, -1};
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int neighborLive = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (neighbors[i] == 0 && neighbors[j] == 0) {
                            continue;
                        }
                        // 相邻位置的坐标
                        int r = row + neighbors[i];
                        int c = col + neighbors[j];
                        // 查看相邻的细胞是否是活细胞
                        if (r >= 0 && r < rows && c >= 0 && c < cols && Math.abs(board[r][c]) == 1) {
                            neighborLive++;
                        }
                    }
                }
                // 规则 1 或规则 3
                if (board[row][col] == 1 && (neighborLive < 2 || neighborLive > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && neighborLive == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //1:过去是活的现在也是活，2：过去是死现在是活
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {//0：过去是死现在也是死，-1：过去是活现在是死
                    board[row][col] = 0;
                }
            }
        }

    }
}
