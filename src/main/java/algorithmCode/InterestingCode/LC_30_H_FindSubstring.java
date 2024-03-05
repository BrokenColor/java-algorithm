package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 *
 * @Author bc
 * @Date 2023/6/9 20:25
 * @Description: 滑动窗口
 */
public class LC_30_H_FindSubstring {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        LC_30_H_FindSubstring solution = new LC_30_H_FindSubstring();
        String[] words = {"a", "b"};
        List<Integer> integerList = solution.findSubstring("aaa", words);
        System.out.println(integerList);
    }

    //Time Limit Exceeded
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int length = words.length;
        int wordLength = words[0].length();
        int mathLength = wordLength * length;
        if (mathLength > s.length()) {
            return ans;
        }
        //全排列数组
        boolean[] used = new boolean[length];
        permutation(words, new LinkedList<>(), used);
        int left = 0, right = mathLength - 1;
        while (right < s.length()) {
            String substring = s.substring(left, right + 1);

            if (substring.contains(words[0]) && result.contains(substring)) {
                ans.add(left);
            }
            left++;
            right++;
        }
        return ans;
    }

    //全排列
    private void permutation(String[] words, LinkedList<String> track, boolean[] used) {
        if (words.length == track.size()) {
            String item = String.join("", track);
            result.add(item);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (used[i]) continue;
            track.add(words[i]);
            used[i] = true;
            permutation(words, track, used);
            used[i] = false;
            track.removeLast();
        }
    }
}