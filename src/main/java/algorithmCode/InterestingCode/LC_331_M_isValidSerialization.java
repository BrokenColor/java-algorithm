package algorithmCode.InterestingCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化
 *
 * @Author bc
 * @Date 2024/3/31 11:44
 * @Description: 栈
 */
public class LC_331_M_isValidSerialization {

    public static void main(String[] args) {
        LC_331_M_isValidSerialization solution = new LC_331_M_isValidSerialization();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(solution.isValidSerialization("9,#,92,#,#"));
    }

    /**
     * 验证给定的字符串是否表示一棵二叉树的前序序列化。
     *
     * @param preorder 表示二叉树前序序列化的字符串。字符串中只包含字符'#, '和数字，'#'代表空节点。
     * @return 如果给定的字符串可以被解析为一棵二叉树的前序序列化，返回true；否则返回false。
     */
    public boolean isValidSerialization(String preorder) {
        int length = preorder.length(); // 字符串长度
        Deque<Integer> stack = new LinkedList<>(); // 使用栈来模拟树的构建过程
        stack.push(1); // 初始化栈，表示当前正在处理的子树的节点数为1
        int index = 0; // 字符串索引
        while (index < length) {
            if (stack.isEmpty()) return false; // 如果栈为空，则序列化无效

            if (preorder.charAt(index) == ',') {
                index++; // 跳过逗号分隔符
            }
            if (preorder.charAt(index) == '#') {
                // 当遇到空节点'#'时，弹出栈顶元素并检查其值
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top); // 如果弹出的元素大于1，说明还有左子树未处理，将其重新入栈
                }
                index++;
            } else {
                // 当遇到数字节点时，读取整个数字并处理
                while (index < length && preorder.charAt(index) != ',') {
                    index++;
                }
                int top = stack.pop() - 1; // 弹出栈顶元素，表示当前节点的右子树处理完毕
                if (top > 0) {
                    stack.push(top); // 如果弹出的元素大于1，说明还有左子树未处理，将其重新入栈
                }
                stack.push(2); // 将2入栈，表示当前节点的右子树节点数为2（包含当前节点和空节点）
            }
        }
        return stack.isEmpty(); // 最后栈应为空，表示所有节点都已正确处理
    }
}
