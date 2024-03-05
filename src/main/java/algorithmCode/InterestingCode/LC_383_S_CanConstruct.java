package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 383.赎金信
 *
 * @Author bc
 * @Date 2023/6/18 21:07
 * @Description: 哈希表
 */
public class LC_383_S_CanConstruct {

    public static void main(String[] args) {
        LC_383_S_CanConstruct solution = new LC_383_S_CanConstruct();
        System.out.println(solution.canConstruct("a", "b"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.getOrDefault(c, 0) == 1) {
                map.remove(c);
            } else if (map.getOrDefault(c, 0) > 1) {
                map.put(c, map.get(c) - 1);
            }
        }
        return map.size() == 0;
    }
}
