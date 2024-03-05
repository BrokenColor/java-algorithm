package algorithmCode.InterestingCode;

/**
 * 392. 判断子序列
 */
public class LC_392_S_IsSubsequence {

    public static void main(String[] args) {
        LC_392_S_IsSubsequence solution = new LC_392_S_IsSubsequence();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int tIndex = 0, sIndex = 0;
        while (tIndex < tLen && sIndex < sLen) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == sLen;
    }

    public boolean isSubsequence1(String s, String t) {
        if ("".equals(s)) return true;
        int length = t.length();
        for (int i = 0; i < length; i++) {
            if (i >= s.length()) {
                return false;
            }
            int p1 = i;
            int p2 = 0;
            while (p1 < length && p2 < s.length()) {
                if (t.charAt(p1) == s.charAt(p2)) {
                    p2++;
                }
                p1++;
            }
            if (p2 == s.length()) {
                return true;
            }
        }
        return false;
    }
}
