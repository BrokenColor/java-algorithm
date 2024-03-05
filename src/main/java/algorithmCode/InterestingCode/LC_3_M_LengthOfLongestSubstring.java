package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @author bc
 * @date 2022/4/7 20:29
 */
public class LC_3_M_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        LC_3_M_LengthOfLongestSubstring solution = new LC_3_M_LengthOfLongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0; //记录结果
        while (right < s.length()) {
            char charAtRight = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(charAtRight, window.getOrDefault(charAtRight, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(charAtRight) > 1) {
                char charAtLeft = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(charAtLeft, window.get(charAtLeft) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
