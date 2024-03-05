package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 274. H 指数
 *
 * @Author bc
 * @Date 2023/5/17 21:36
 * @Description: TODO
 */
public class LC_274_M_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        LC_274_M_HIndex solution = new LC_274_M_HIndex();
        System.out.println(solution.hIndex(citations));
    }

    public int hIndex(int[] citations) {
        //排序
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        //从大往小找，
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
