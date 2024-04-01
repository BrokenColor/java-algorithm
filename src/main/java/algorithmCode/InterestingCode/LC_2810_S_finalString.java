package algorithmCode.InterestingCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2810.故障键盘
 *
 * @Author bc
 * @Date 2024/4/1 23:23
 * @Description: 字符串
 */
public class LC_2810_S_finalString {

    public static void main(String[] args) {
        LC_2810_S_finalString solution = new LC_2810_S_finalString();
        System.out.println(solution.finalString("string"));//"rtsng"
        System.out.println(solution.finalString("poiinter"));//"ponter"
    }

    /**
     * 根据指定规则重新排列字符串并返回。
     * 规则：字符串中每个字符根据出现的字母 'i' 的前后位置决定其在结果字符串中的顺序。
     * 如果字符出现在 'i' 前，则保持原顺序加入结果字符串；如果在 'i' 后，则逆序加入结果字符串。
     *
     * @param s 待重新排列的字符串。
     * @return 根据规则重新排列后的字符串。
     */
    public String finalString(String s) {
        // 使用双向队列来暂存字符
        Deque<Character> stack = new LinkedList<>();
        // 标记当前是否位于 'i' 的左侧
        boolean head = false;

        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            // 遇到 'i' 字符时，切换左右侧的标记
            if (charAt == 'i') {
                head = !head;
            } else {
                // 根据是否位于 'i' 的左侧，决定字符加入的位置
                if (head) {
                    stack.offerLast(charAt);
                } else {
                    stack.offerFirst(charAt);
                }
            }
        }

        // 根据 head 的值决定字符的出队顺序，构建最终字符串
        StringBuilder sb = new StringBuilder();
        if (head) {
            // 从队首到队尾出队，保持原顺序
            while (!stack.isEmpty()) {
                sb.append(stack.pollFirst());
            }
        } else {
            // 从队尾到队首出队，逆序加入字符串
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
        }

        return sb.toString();
    }
}
