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

    /**
     * 评估逆波兰表达式。
     *
     * @param tokens 代表逆波兰表达式的字符串数组，其中每个元素要么是整数，要么是四则运算符（+、-、*、/）
     * @return 逆波兰表达式计算结果的整数值
     */
    public int evalRPN(String[] tokens) {
        // 使用双端队列模拟栈的操作
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            // 如果是数字，则将其转换为整数并入栈
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // 如果是运算符，则弹出栈顶两个元素进行运算，并将结果入栈
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
                        // 对于未知运算符，不进行任何操作，此处省略了default的实现细节
                }
            }
        }
        // 最后栈中剩余的数字即为表达式的计算结果
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
