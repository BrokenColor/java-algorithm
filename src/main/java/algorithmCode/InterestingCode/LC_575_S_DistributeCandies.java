package algorithmCode.InterestingCode;

import java.util.HashSet;

/**
 * 575. 分糖果
 * @Author bc
 * @Date 2024/6/2 10:39
 * @Description: TODO
 */
public class LC_575_S_DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for (int item : candyType) {
            set.add(item);
        }
        return Math.min(n / 2, set.size());
    }
}
