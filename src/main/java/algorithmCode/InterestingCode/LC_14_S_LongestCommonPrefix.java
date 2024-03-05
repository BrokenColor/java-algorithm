package algorithmCode.InterestingCode;

/**
 * 14. 最长公共前缀
 */
public class LC_14_S_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LC_14_S_LongestCommonPrefix solution = new LC_14_S_LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //数组中第一个字符的长度
        int length = strs[0].length();
        //数组的长度
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            //第一个字符的第i个字符
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                //第j个字符串字符遍历完了，或者第j个字符串i字符与c不同 则结束
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
