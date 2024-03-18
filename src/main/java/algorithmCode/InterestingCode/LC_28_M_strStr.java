package algorithmCode.InterestingCode;

/**
 * 28. 找出字符串中第一个匹配项的下标
 *
 */
public class LC_28_M_strStr {
    public static void main(String[] args) {
        LC_28_M_strStr solution = new LC_28_M_strStr();
//        System.out.println(solution.strStr("sadbutsad","sad"));
        System.out.println(solution.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        int p1 = 0, p2 = 0;
        while (p1 < haystack.length()) {
            char c1 = haystack.charAt(p1);
            char c2 = needle.charAt(p2);
            if (c1 == c2) {
                p2++;
                if (p2 == needle.length()) {
                    return p1 - needle.length() + 1;
                }
                p1++;
            } else {
                //p1退到相同的地方
                p1 = p1 - p2 + 1;
                p2 = 0;
            }

        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        //遍历haystack
        for (int i = 0; i <= m - n; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < n && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (n == b) return i;

        }
        return -1;
    }
}
