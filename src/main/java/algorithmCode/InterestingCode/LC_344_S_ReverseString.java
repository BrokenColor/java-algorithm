package algorithmCode.InterestingCode;

/**
 * 344.反转字符数组
 * @author guwanli
 * @date 2022/11/22 16:18
 */
public class LC_344_S_ReverseString {

    public static void main(String[] args) {
        LC_344_S_ReverseString solution = new LC_344_S_ReverseString();
//        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        char[] chars = {'H','a','n','n','a','h'};
        solution.reverseString(chars);
        System.out.println(chars);
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        // 一左一右两个指针相向而行
        while (l < r) {
            // 交换 s[l] 和 s[r]
            char tmp =s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;r--;
        }
    }

}
