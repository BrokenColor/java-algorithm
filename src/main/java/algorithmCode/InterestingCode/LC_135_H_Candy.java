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

    /**
     * 给定一个由 ratings 组成的数组，其中 ratings[i] 表示第 i 个学生的评分。
     * 每个学生至少分配到一个糖果，且评分较高的学生需要分配到比他们评分较低的邻居更多的糖果。
     * 计算分配糖果的最小数量。
     *
     * @param ratings 学生评分数组。
     * @return 分配糖果的最小数量。
     */
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length]; // 用于记录从左往右看时，每个学生能拿到的最少糖果数
        int ret = 0; // 记录总的糖果数量
        // 从左往右遍历，保证右边评分更高的学生拿到的糖果多于左边评分低的学生
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0; // 用于记录从右往左看时，每个学生能拿到的最少糖果数
        // 从右往左遍历，保证左边评分更高的学生拿到的糖果多于右边评分低的学生
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right); // 糖果数量累加，取左边和右边最少糖果数的较大值
        }
        return ret;
    }
}
