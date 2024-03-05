package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 *
 * @Author bc
 * @Date 2024/3/4 23:51
 * @Description: 滑动窗口
 */
public class LC_438_M_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, vaild = 0;
        while (right < s.length()) {
            //扩大窗口
            char charRight = s.charAt(right);
            right++;
            if (need.containsKey(charRight)) {
                window.put(charRight, window.getOrDefault(charRight, 0) + 1);
                if (window.get(charRight).equals(need.get(charRight))) {
                    vaild++;
                }
            }
            //缩小窗口
            while (right - left >= p.length()) {
                //更新结果集
                if (vaild == need.size()) {
                    res.add(left);
                }
                char charLeft = s.charAt(left);
                left++;
                if (need.containsKey(charLeft)) {
                    if (need.get(charLeft).equals(window.get(charLeft))) {
                        vaild--;
                    }
                    window.put(charLeft, window.get(charLeft) - 1);
                }
            }
        }
        return res;
    }
}
