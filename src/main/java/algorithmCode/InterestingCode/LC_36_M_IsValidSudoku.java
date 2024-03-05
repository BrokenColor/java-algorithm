package algorithmCode.InterestingCode;

/**
 * 36. 有效的数独
 */
public class LC_36_M_IsValidSudoku {
    public static void main(String[] args) {
//        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board = {{'.', '.', '5', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '8', '.', '.', '.', '3', '.'},
                            {'.', '5', '.', '.', '2', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '9'},
                            {'.', '.', '.', '.', '.', '.', '4', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '7'},
                            {'.', '1', '.', '.', '.', '.', '.', '.', '.'},
                            {'2', '4', '.', '.', '.', '.', '9', '.', '.'}};
        LC_36_M_IsValidSudoku solution = new LC_36_M_IsValidSudoku();
        System.out.println(solution.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char c = board[i][j];
                if (c != '.' && !isValid(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int col, int row, char[][] board) {
        int length = board.length;
        char c = board[col][row];
        //判断行
        for (int i = row; i < length; i++) {
            if (i != row && c == board[col][i]) {
                return false;
            }
        }
        //判断列
        for (int i = col; i < length; i++) {
            if (i != col && c == board[i][row]) {
                return false;
            }
        }
        //判断3*3宫格
        int left = (row / 3) * 3;
        int right = left + 3;
        int top = (col / 3) * 3;
        int bottom = top + 3;
        for (int i = col + 1; i < bottom; i++) {
            for (int j = 0; j < right; j++) {
                if (c == board[i][j]) return false;
            }
        }
        return true;
    }
}
