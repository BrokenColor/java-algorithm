package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 2129.将比昂题首字母大写
 *
 * @Author bc
 * @Date 2024/3/11 21:37
 * @Description:
 */
public class LC_S_2129_CapitalizeTitle {
    public static void main(String[] args) {
        LC_S_2129_CapitalizeTitle solution = new LC_S_2129_CapitalizeTitle();
        System.out.println(solution.capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(solution.capitalizeTitle1("capiTalIze tHe titLe"));
    }

    /**
     * 双指针
     *
     * @param title
     * @return
     */
    public String capitalizeTitle(String title) {
        //把字符串都转成小写
        String lowerCase = title.toLowerCase();
        char[] chars = lowerCase.toCharArray();
        int index = 0;//记录头指针
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int len = i - index;
                if (len > 2) {//判断字符串长度
                    //把字符串头转成大写
                    chars[index] = (char) (chars[index] - 32);
                }
                index = i + 1;
            }
        }
        //遍历完之后，index指针到结尾大于2的话要把index转成大写
        if (chars.length - index > 2) {
            chars[index] = (char) (chars[index] - 32);
        }
        return new String(chars);
    }

    /**
     * split
     *
     * @param title
     * @return
     */
    public String capitalizeTitle1(String title) {
        //把字符串都转成小写
        String lowerCase = title.toLowerCase();
        //通过空格分割字符
        String[] split = lowerCase.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 2) {//字符长度大于2的 把首字母变成大写
                char[] charArray = split[i].toCharArray();
                charArray[0] = (char) (charArray[0] - 32);
                split[i] = new String(charArray);
            }
        }
        //拼接上空格返回
        return Arrays.stream(split).map(String::new).collect(Collectors.joining(" "));
    }
}
