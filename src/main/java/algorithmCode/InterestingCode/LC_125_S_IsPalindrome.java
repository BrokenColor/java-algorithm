package algorithmCode.InterestingCode;

/**
 * 125.验证回文串
 */
public class LC_125_S_IsPalindrome {

    public static void main(String[] args) {
        LC_125_S_IsPalindrome solution = new LC_125_S_IsPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 判断给定的字符串是否是回文。
     * 注意：忽略字符串中的非字母和数字字符，并且不区分大小写。
     *
     * @param s 待检查的字符串
     * @return 如果字符串是回文，则返回true；否则返回false。
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        // 遍历字符串，只保留字母和数字，并转为小写
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        // 使用双指针法检查处理后的字符串是否为回文
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            // 如果左右字符不相等，则不是回文
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
