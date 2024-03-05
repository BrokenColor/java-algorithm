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

    public String reverseWords(String s) {
        String trim = s.trim();
        List<String> stringList = Arrays.asList(trim.split("\\s+"));
        Collections.reverse(stringList);
        return String.join(" ", stringList);
    }

    public String reverseWords1(String s) {
        //去除空格
        StringBuilder sb = trimSpace(s);
        //反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        //反转单词
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
     * 反转字符串
     *
     * @param sb
     * @param left
     * @param right
     */
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            //左右交换字符
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
