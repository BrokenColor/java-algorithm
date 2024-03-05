package algorithmCode.InterestingCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71.简化路径
 */
public class LC_71_M_SimplifyPath {
    public static void main(String[] args) {
        LC_71_M_SimplifyPath solution = new LC_71_M_SimplifyPath();
        String path = "/home/";
        System.out.println(solution.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            stringBuilder.append("/");
        } else {
            while (!stack.isEmpty()) {
                stringBuilder.append("/");
                stringBuilder.append(stack.pollFirst());
            }
        }
        return stringBuilder.toString();
    }
}
