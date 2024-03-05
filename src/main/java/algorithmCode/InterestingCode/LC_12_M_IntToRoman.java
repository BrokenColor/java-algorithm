package algorithmCode.InterestingCode;

/**
 * 12. 整数转罗马数字
 */
public class LC_12_M_IntToRoman {

    public static void main(String[] args) {
        LC_12_M_IntToRoman solution = new LC_12_M_IntToRoman();
        System.out.println(solution.intToRoman(3));
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                stringBuilder.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
