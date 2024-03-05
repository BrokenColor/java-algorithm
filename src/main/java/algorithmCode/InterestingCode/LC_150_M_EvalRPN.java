package algorithmCode.InterestingCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150.逆波兰表达式求值
 *
 * @Author bc
 * @Date 2023/8/4 23:32
 * @Description: 栈
 */
public class LC_150_M_EvalRPN {

    public static void main(String[] args) {
        LC_150_M_EvalRPN solution = new LC_150_M_EvalRPN();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
