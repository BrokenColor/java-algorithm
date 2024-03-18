package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * @date 2022/1/21 20:29
 */
public class LC_76_H_MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        LC_76_H_MinWindow solution = new LC_76_H_MinWindow();
        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        //定义滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        //把t字符串加入到 need map中
        for (int i = 0; i < t.length(); i++) {
            char charAt = t.charAt(i);
            need.put(charAt, need.getOrDefault(charAt, 0) + 1);
        }
        //定义双指针，查找符合要求的范围
        int left = 0, right = 0;
        int valid = 0;//记录符合要求的数
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //元素加入到滑动窗口
            char rightChar = s.charAt(right);
            //右指针 向有走
            right++;
            //字符符合要求则加入到 need
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (window.get(rightChar).equals(need.get(rightChar))) {
                    //字符数量也相同，有效的数量也增加
                    valid++;
                }
            }
            //如果有效的数量与 需要处理的字符相同，在左侧开始收缩，找到当前符合要求的最小字符串
            while (valid == need.size()) {
                //更新最小子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char leftChar = s.charAt(left);
                //左指针 向右走
                left++;
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        //字符数量也相同，有效的数量也减少
                        valid--;
                    }
                    //滑动窗口移除leftChar
                    if (window.get(leftChar) > 0) {
                        window.put(leftChar, window.get(leftChar) - 1);
                    } else {
                        window.remove(leftChar);
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
