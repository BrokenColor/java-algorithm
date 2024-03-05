package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 290.单词规律
 */
public class LC_290_S_WordPattern {

    public static void main(String[] args) {
        LC_290_S_WordPattern solution = new LC_290_S_WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if ((p2s.containsKey(c) && !p2s.get(c).equals(s1[i])) ||
                    (s2p.containsKey(s1[i]) && !s2p.get(s1[i]).equals(c))) {
                return false;
            }
            p2s.put(c, s1[i]);
            s2p.put(s1[i], c);
        }
        return true;
    }
}
