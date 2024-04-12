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

    /**
     * 判断两个字符串是否是同构的。
     * 同构的定义是：一个字符串中的每个字符都可以被替换成别的字符，使得它最终变成另一个字符串。
     * 必须保持字符的替换关系是一一对应的。
     *
     * @param s 第一个字符串
     * @param t 第二个字符串
     * @return 如果两个字符串是同构的，则返回true；否则返回false。
     */
    public boolean isIsomorphic(String s, String t) {
        // 用于存储s到t的字符映射关系
        Map<Character, Character> s2t = new HashMap<>();
        // 用于存储t到s的字符映射关系
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);

            // 如果当前字符的映射关系不符合同构要求，则返回false
            if ((s2t.containsKey(x) && s2t.get(x) != y) ||
                    (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }

            // 更新字符的映射关系
            s2t.put(x, y);
            t2s.put(y, x);
        }

        // 遍历完所有字符后，没有发现不符合同构关系的情况，返回true
        return true;
    }
}
