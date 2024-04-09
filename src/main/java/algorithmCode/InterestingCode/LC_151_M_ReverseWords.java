package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 *
 * @Author bc
 * @Date 2023/5/28 18:35
 * @Description:
 */
public class LC_151_M_ReverseWords {
    public static void main(String[] args) {
        LC_151_M_ReverseWords solution = new LC_151_M_ReverseWords();
        System.out.println(solution.reverseWords(" hello world "));
        System.out.println(solution.reverseWords1(" hello1 world "));
    }

    /**
     * 反转字符串中的单词顺序。
     *
     * @param s 输入的字符串，可能包含前后空格。
     * @return 反转后的字符串，单词的顺序逆转，单词之间以单个空格分隔，不保留原字符串中的前后空格。
     */
    public String reverseWords(String s) {
        // 去除字符串两端的空格
        String trim = s.trim();
        // 将字符串按一个或多个空格分割成单词列表
        List<String> stringList = Arrays.asList(trim.split("\\s+"));
        // 反转单词列表的顺序
        Collections.reverse(stringList);
        // 将反转后的单词列表重新拼接成字符串，单词之间以单个空格分隔
        return String.join(" ", stringList);
    }

    /**
     * 反转字符串中的单词顺序。
     * @param s 输入的字符串，可以包含空格。
     * @return 反转单词顺序后的字符串。
     */
    public String reverseWords1(String s) {
        // 去除字符串两端的空格
        StringBuilder sb = trimSpace(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }


    /**
     * 去除空格
     *
     * @param s
     * @return
     */
    private StringBuilder trimSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        //删除头部的空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        //删除尾部的空格
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        while (left <= right) {
            char c = s.charAt(left);
            //当前字符串不为空
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {//当前字符串为空，sb字符串最后不为空
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    /**
     * 反转字符串中的指定部分。
     * 该方法通过交换字符串中指定范围的字符，来实现这部分字符串的反转。
     *
     * @param sb 被操作的字符串，使用StringBuilder以支持更高效的字符修改操作。
     * @param left 反转操作的起始位置。
     * @param right 反转操作的结束位置。注意，右边界位置本身不包含在反转范围内。
     */
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            // 交换左右位置的字符，实现反转
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }


    private void reverseEachWord(StringBuilder sb) {
        int length = sb.length();
        int start = 0, end = 0;
        while (start < length) {
            // 循环至单词的末尾
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }
            //反转单词
            reverse(sb, start, end - 1);
            //更新start，去找下一个单词
            start = end + 1;
            //当前end处为‘ ’ 所以要前进一部
            end++;
        }
    }
}
