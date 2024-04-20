package algorithmCode.InterestingCode;

/**
 * 67. 二进制求和
 *
 * @Author bc
 * @Date 2024/4/20 14:29
 * @Description: 数组
 */
public class LC_67_S_addBinary {
    public static void main(String[] args) {
        LC_67_S_addBinary solution = new LC_67_S_addBinary();
        System.out.println(solution.addBinary("11", "1"));
    }

    /**
     * 将两个二进制字符串相加。
     *
     * @param a 第一个二进制字符串
     * @param b 第二个二进制字符串
     * @return 两个二进制字符串相加后的结果
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0; // 进位初始化为0

        // 从两个字符串的末尾开始遍历，直到两个字符串中都没有字符为止
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry; // 初始化当前位的和为进位值
            // 获取a字符串当前位的值，如果已经遍历完则默认为0
            int aVal = i >= 0 ? a.charAt(i) - '0' : 0;
            sum += aVal;
            // 获取b字符串当前位的值，如果已经遍历完则默认为0
            int bVal = j >= 0 ? b.charAt(j) - '0' : 0;
            sum += bVal;
            // 将当前位的和添加到结果字符串中
            sb.append(sum % 2);
            carry = sum / 2; // 更新进位值
        }
        // 如果最后还有进位，将其添加到结果字符串中
        sb.append(carry == 1 ? carry : "");
        // 结果字符串反转，使得其顺序正确
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        int carry = 0, index = 0;
        String[] aArrs = a.split("");
        String[] bArrs = b.split("");
        int len = Math.max(aArrs.length, bArrs.length);
        int[] res = new int[len];
        while (index < aArrs.length && index < bArrs.length) {
            int aValue = Integer.parseInt(aArrs[aArrs.length - 1 - index]);
            int bValue = Integer.parseInt(bArrs[bArrs.length - 1 - index]);
            int tmp = aValue + bValue + carry;
            if (tmp == 2) {
                tmp = 0;
                carry = 1;
            } else if (tmp == 3) {
                tmp = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            res[len - 1 - index] = tmp;
            index++;
        }
        while (index < aArrs.length) {
            int aValue = Integer.parseInt(aArrs[aArrs.length - 1 - index]);
            int tmp = aValue + carry;
            if (tmp == 2) {
                tmp = 0;
                carry = 1;
            } else if (tmp == 3) {
                tmp = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            res[len - 1 - index] = tmp;
            index++;
        }
        while (index < bArrs.length) {
            int bValue = Integer.parseInt(bArrs[bArrs.length - 1 - index]);
            int tmp = bValue + carry;
            if (tmp == 2) {
                tmp = 0;
                carry = 1;
            } else if (tmp == 3) {
                tmp = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            res[len - 1 - index] = tmp;
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int re : res) {
            sb.append(re);
        }
        if (carry == 1) {
            return "1" + sb;
        }
        return sb.toString();
    }


    public String addBinary1(String a, String b) {
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        return Integer.toBinaryString(sum);
    }
}
