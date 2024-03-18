package algorithmCode.InterestingCode;

/**
 * 13. 罗马数字转整数
 * @Author bc
 * @Date 2023/5/24 11:40
 */
public class LC_13_S_RomanToInt {
    public static void main(String[] args) {
        String s = "III";
        LC_13_S_RomanToInt solution = new LC_13_S_RomanToInt();
        System.out.println(solution.romanToInt(s));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (preNum < value) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = value;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char c) {
        //字符          数值
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
