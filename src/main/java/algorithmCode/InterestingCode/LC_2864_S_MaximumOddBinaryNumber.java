package algorithmCode.InterestingCode;

/**
 * 2864.最大二进制奇数
 *
 * @Author bc
 * @Date 2024/3/13 21:11
 * @Description: TODO
 */
public class LC_2864_S_MaximumOddBinaryNumber {

    public static void main(String[] args) {
        LC_2864_S_MaximumOddBinaryNumber soultion = new LC_2864_S_MaximumOddBinaryNumber();
        System.out.println(soultion.maximumOddBinaryNumber("010"));
        System.out.println(soultion.maximumOddBinaryNumber("01010"));
    }

    public String maximumOddBinaryNumber(String s) {
        int ch = 0;
        //统计字符串中'1'的个数
        for (int i = 0; i < s.length(); i++) {
            ch += s.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        //拼接ch-1个'1'
        for (int i = 0; i < ch - 1; i++) {
            sb.append('1');
        }
        //拼接s.length()-ch个'0'
        for (int i = 0; i < s.length() - ch; i++) {
            sb.append('0');
        }
        //最后凭借一个'1'
        sb.append('1');
        return sb.toString();
    }
}
