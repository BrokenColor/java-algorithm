package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *
 * @date 2022/1/25 11:00
 */
public class LC_567_M_CheckInclusion {
    public static void main(String[] args) {
//        String s1 = "ab", s2 = "eidboaooo";
        String s1 = "abcdxabcde", s2 = "abcdeabcdx";
        LC_567_M_CheckInclusion solution = new LC_567_M_CheckInclusion();
        System.out.println(solution.checkInclusion(s1, s2));
    }

    //滑动窗口
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //先把需要s1加入到need Map中
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            //右侧指针向前
            right++;
            //添加到 滑动窗口中
            if (need.containsKey(rightChar)) {
                //加入到滑动窗口中
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    //数量一致，有效的数量增加
                    valid++;
                }
            }
            //如果滑动中的字符长度大于等于 s1 长度则进行左侧收缩
            while (right - left >= s1.length()) {
                //如果有效字段与need大小相同 则说明存在
                if (need.size() == valid) {
                    return true;
                }
                //取出双指针中左侧字符
                char leftChar = s2.charAt(left);
                //左指针向前走
                left++;
                //移除左侧字符
                if (need.containsKey(leftChar)) {
                    //更新有效数：数量一致，有效的数量减一
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        valid--;
                    }
                    //更新滑动窗口
                    if (window.get(leftChar) > 0) {
                        window.put(leftChar, window.get(leftChar) - 1);
                    } else {
                        window.remove(leftChar);
                    }
                }
            }
        }
        return false;
    }
}