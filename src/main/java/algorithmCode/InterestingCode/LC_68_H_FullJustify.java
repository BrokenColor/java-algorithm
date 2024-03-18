package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * @Author bc
 * @Date 2023/6/2 23:00
 * @Description:
 */
public class LC_68_H_FullJustify {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        LC_68_H_FullJustify solution = new LC_68_H_FullJustify();
        System.out.println(solution.fullJustify(words, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        //words中当前指针
        int right = 0;
        int n = words.length;
        while (true) {
            //当前行中第一个单词在words中的指针
            int left = right;
            //当前行单词长度
            int sumLength = 0;
            //判断当前行能放多少单词，每个单词有一个空格（right - left）
            while (right < n && sumLength + words[right].length() + right - left <= maxWidth) {
                sumLength += words[right++].length();
            }
            //当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                StringBuilder builder = new StringBuilder();
                //每个单词后拼接一个空格
                builder.append(join(words, left, right, " "));
                //最后全拼接空格
                builder.append(blank(maxWidth - builder.length()));
                //加入结果集
                ans.add(builder.toString());
                return ans;
            }
            int sumWord = right - left;
            //当只有一个单词时
            if (sumWord == 1) {
                //拼接单词
                StringBuilder builder = new StringBuilder(words[left]);
                //最后全拼接空格
                builder.append(blank(maxWidth - builder.length()));
                //加入结果集
                ans.add(builder.toString());
                continue;
            }
            //当有多个单词时
            //空格数
            int numSpace = maxWidth - sumLength;
            //平均每个单词后面的空格数，（为什么sumWord - 1：最后一个单词不拼空格）
            int avgSpace = numSpace / (sumWord - 1);
            //每个单词分配avgSpace个空格后余出来的空格数
            int extraSpaces = numSpace % (sumWord - 1);
            StringBuilder builder = new StringBuilder();
            //给前extraSpaces个单词 拼接额外加一个空格的单词
            builder.append(join(words, left, left + extraSpaces + 1, blank(avgSpace + 1)));
            //拼接avgSpace个空格（因为拼接上一个拼接字符是最后一个字符没有拼接空格）
            builder.append(blank(avgSpace));
            // 其余单词拼接avgSpace个空格
            builder.append(join(words, left + extraSpaces + 1, right, blank(avgSpace)));
            //加入结果集
            ans.add(builder.toString());
        }
    }

    //返回长度为 n 的由空格组成的字符串
    private String blank(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }

    //返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    private String join(String[] words, int left, int right, String sep) {
        StringBuilder builder = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; i++) {
            //空格加在前面需要注意
            builder.append(sep);
            builder.append(words[i]);
        }
        return builder.toString();
    }
}
