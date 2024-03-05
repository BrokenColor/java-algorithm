package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 242.有效的字母异位词
 *
 * @Author bc
 * @Date 2023/6/21 21:12
 * @Description: 哈希表
 */
public class LC_242_S_IsAnagram {
    public static void main(String[] args) {
        LC_242_S_IsAnagram solution = new LC_242_S_IsAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram1("anagram", "nagaram"));
    }

    /**
     * 哈希表
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if ('a' <= c && c <= 'z') {
                if (!map.containsKey(c)) {
                    return false;
                } else if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.getOrDefault(c, 0) - 1);
                }
            }
        }
        return map.isEmpty();
    }

    /**
     * 数组
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
