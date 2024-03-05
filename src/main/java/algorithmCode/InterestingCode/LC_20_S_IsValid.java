package algorithmCode.InterestingCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20.有效括号
 *
 * @Author bc
 * @Date 2023/3/11 15:31
 * @Description: TODO
 */
public class LC_20_S_IsValid {

    public static void main(String[] args) {
        LC_20_S_IsValid isValid = new LC_20_S_IsValid();
        System.out.println(isValid.isValid("()"));
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> paris = new HashMap<>();
        paris.put(')', '(');
        paris.put(']', '[');
        paris.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (paris.containsKey(charAt)) {
                if (stack.isEmpty() || stack.pop() != paris.get(charAt)) {
                    return false;
                }
            } else {
                stack.push(charAt);

            }
        }
        return stack.isEmpty();
    }
}
