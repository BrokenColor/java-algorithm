package algorithmCode.InterestingCode;

/**
 * 1143. 最长公共子序列
 *
 * @author guwanli
 * @date 2021/12/23 11:07
 */
public class LC_1143_M_LongestCommonSubsequence {
    public static void main(String[] args) {
        LC_1143_M_LongestCommonSubsequence solution = new LC_1143_M_LongestCommonSubsequence();
        String text1 = "abcde", text2 = "ace";
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }

    //转化为二维数组
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < 1 || text2.length() < 1) return 0;
        int length1 = text1.length();
        int length2 = text2.length();
        //存储中间结果
        int[][] dp = new int[length1 + 1][length2 + 1];
        //从1开始防止越界
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                //如果相同去左上角的值+1，作为当前的值
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //左侧和上侧中取较大的一个作为当前的值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
