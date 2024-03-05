package algorithmCode.InterestingCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224.基本计算器
 *
 * @Author bc
 * @Date 2023/8/5 23:41
 * @Description: 栈
 */
public class LC_224_H_Calculate {

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        LC_224_H_Calculate solution = new LC_224_H_Calculate();
        System.out.println(solution.calculate(s));
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int i = 0, n = s.length();
        while (i < n) {
            char charAt = s.charAt(i);
            switch (charAt) {
                case ' ':
                    i++;
                    break;
                case '+':
                    sign = ops.peek();
                    i++;
                    break;
                case '-':
                    sign = -ops.peek();
                    i++;
                    break;
                case '('://记录符号
                    ops.push(sign);
                    i++;
                    break;
                case ')'://弹出符号
                    ops.pop();
                    i++;
                    break;
                default:
                    long num = 0;
                    //遍历取出字符构建数字
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
            }

        }
        return ret;
    }
}
