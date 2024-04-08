package algorithmCode.InterestingCode;

/**
 * 1143. 最长公共子序列
 *
 * @author bc
 * @date 2021/12/23 11:07
 */
public class LC_1143_M_LongestCommonSubsequence {
    public static void main(String[] args) {
        LC_1143_M_LongestCommonSubsequence solution = new LC_1143_M_LongestCommonSubsequence();
        String text1 = "abcde", text2 = "ace";
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }

    /**
     * 计算两个字符串的最长公共子序列的长度。
     * @param text1 第一个字符串
     * @param text2 第二个字符串
     * @return 两个字符串的最长公共子序列的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 如果任一字符串长度为0，直接返回0
        if (text1.length() < 1 || text2.length() < 1) return 0;
        int length1 = text1.length();
        int length2 = text2.length();

        // 使用动态规划数组dp存储中间结果
        int[][] dp = new int[length1 + 1][length2 + 1];

        // 填充动态规划数组
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // 如果当前字符相同，则当前长度为左上角长度加1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果当前字符不同，则当前长度为左侧和上侧长度的较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 返回最终结果
        return dp[length1][length2];
    }

}
