package algorithmCode.InterestingCode;

import java.util.ArrayList;

/**
 * 6. N 字形变换
 * 字符串
 */
public class LC_6_M_Convert {
    public static void main(String[] args) {
        LC_6_M_Convert solution = new LC_6_M_Convert();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        //构建
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            //掉头
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        //拼接结果
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
