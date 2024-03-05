package algorithmCode.InterestingCode;
/**
 * 135. 分发糖果
 *
 * @author bc
 * @date 2023/5/22 10:54
 */
public class LC_135_H_Candy {

    public static void main(String[] args) {
        int[] ratings ={1,0,2};
        LC_135_H_Candy solution = new LC_135_H_Candy();
        System.out.println(solution.candy(ratings));
    }

    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int ret = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}
