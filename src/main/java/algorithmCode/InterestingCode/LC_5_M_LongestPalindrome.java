package algorithmCode.InterestingCode;

/**
 * 5.最长回文子串
 *
 * @author bc
 * @date 2022/11/22 15:34
 * 双指针
 */
public class LC_5_M_LongestPalindrome {

    public static void main(String[] args) {
        LC_5_M_LongestPalindrome solution = new LC_5_M_LongestPalindrome();
        String s = "babad";
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //寻找以s[i]为中心的最长回文串
            String str1 = palindrome(s, i, i);
            //寻找以s[i],s[i+1]为中心的最长回文串
            String str2 = palindrome(s, i, i + 1);
            //更新结果
            res = res.length() >= str1.length() ? res : str1;
            res = res.length() >= str2.length() ? res : str2;
        }
        return res;
    }

    /**
     * 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
     *
     * @param s 带查找字符串
     * @param l 左指针
     * @param r 右指针
     * @return 最长回文子串
     */
    public String palindrome(String s, int l, int r) {
        //判断
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            l--;//左指针向左走
            r++;//右指针向右走
        }
        //截取回文子串
        return s.substring(l + 1, r);
    }
}
