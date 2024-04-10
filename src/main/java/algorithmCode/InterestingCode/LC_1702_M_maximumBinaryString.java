package algorithmCode.InterestingCode;

/**
 * 1702. 修改后的最大二进制字符串
 *
 * @Author bc
 * @Date 2024/4/10 23:39
 * @Description: 字符串
 */
public class LC_1702_M_maximumBinaryString {

    public static void main(String[] args) {
        LC_1702_M_maximumBinaryString solution = new LC_1702_M_maximumBinaryString();
        System.out.println(solution.maximumBinaryString("000110"));
        System.out.println(solution.maximumBinaryString1("000110"));
    }

    /**
     * 将给定的二进制字符串中的所有0转换为1，但保留第一个出现的0，并返回新的二进制字符串。
     *
     * @param binary 输入的二进制字符串，只包含0和1。
     * @return 转换后的二进制字符串，其中所有0都被转换为1，但第一个出现的0会被保留。
     */
    public String maximumBinaryString(String binary) {
        // 查找字符串中第一个0的位置
        int index = binary.indexOf('0');
        if (index < 0) {
            // 如果没有0，则直接返回原字符串
            return binary;
        }
        int zeros = 0;
        char[] chars = binary.toCharArray();
        // 统计字符串中0的个数，并将所有字符转换为1
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') zeros++;
            chars[i] = '1';
        }
        // 将第一个0之后的指定个数的1转换为0，以保留第一个0
        chars[index + zeros - 1] = '0';
        return new String(chars);
    }

    /**
     * 将给定的二进制字符串中尽可能多的0转换为1，使得生成的二进制字符串中任意两个相邻的字符不相同。
     * 该方法首先遍历二进制字符串，遇到0时，会寻找下一个0并将其替换为1，同时将当前0变为1。
     * 这样做可以保证转换后的字符串中任意两个相邻字符不相同。
     *
     * @param binary 给定的二进制字符串
     * @return 转换后的二进制字符串，其中任意两个相邻字符不相同
     */
    public String maximumBinaryString1(String binary) {
        int n = binary.length(); // 获取二进制字符串的长度
        int index = 0; // 用于记录下一个要替换的1的位置
        char[] chars = binary.toCharArray(); // 将二进制字符串转换为字符数组方便处理

        // 遍历字符数组，遇到0则进行替换操作
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') { // 遇到0字符
                // 寻找下一个0的位置
                while (index <= i || (index < n && chars[index] == '1')) {
                    index++;
                }
                // 如果找到了下一个0，则替换为1，并在当前0的位置设置为1，在其后设置一个0
                if (index < n) {
                    chars[i] = '1';
                    chars[index] = '1';
                    chars[i + 1] = '0';
                }
            }
        }
        // 将处理后的字符数组转换回字符串并返回
        return new String(chars);
    }
}
