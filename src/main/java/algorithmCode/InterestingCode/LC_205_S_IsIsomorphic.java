package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 205.同构字符串
 *
 * @Author bc
 * @Date 2023/6/19 22:31
 * @Description: 哈希表
 */
public class LC_205_S_IsIsomorphic {
    public static void main(String[] args) {
        LC_205_S_IsIsomorphic solution = new LC_205_S_IsIsomorphic();
        System.out.println(solution.isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) ||
                    (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);

        }
        return true;
    }
}
