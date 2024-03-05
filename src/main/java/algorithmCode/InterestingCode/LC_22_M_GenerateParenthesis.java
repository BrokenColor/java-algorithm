package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 *
 * @author guwanli
 * @date 2021/12/8 10:02
 */
public class LC_22_M_GenerateParenthesis {
    List<String> result;

    public static void main(String[] args) {
        LC_22_M_GenerateParenthesis solution = new LC_22_M_GenerateParenthesis();
        System.out.println(solution.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if (n < 1) return null;
        int left = 0, right = 0;
        recursion(left + 1, right, "(", n);
        return result;
    }

    //递归
    private void recursion(int left, int right, String Str, int n) {
        //1.终结条件
        if (left == right && left == n) {
            result.add(Str);
        }
        //2.处理当前逻辑

        //3.进入下一层
        if (left < n) {
            recursion(left + 1, right, Str + "(", n);
        }
        if (right < left) {
            recursion(left, right + 1, Str + ")", n);
        }

        //4.清除当前层数据
    }
}
