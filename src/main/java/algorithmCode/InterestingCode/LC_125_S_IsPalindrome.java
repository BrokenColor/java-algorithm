package algorithmCode.InterestingCode;

/**
 * 125.验证回文串
 */
public class LC_125_S_IsPalindrome {

    public static void main(String[] args) {
        LC_125_S_IsPalindrome solution = new LC_125_S_IsPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
