package algorithmCode.InterestingCode;

/**
 * 58. 最后一个单词的长度
 */
public class LC_58_S_LengthOfLastWord {
    public static void main(String[] args) {
        LC_58_S_LengthOfLastWord solution = new LC_58_S_LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        int length = s.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
