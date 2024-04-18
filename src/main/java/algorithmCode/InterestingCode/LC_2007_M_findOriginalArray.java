package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2007. 从双倍数组中还原原数组
 *
 * @Author bc
 * @Date 2024/4/18 23:18
 * @Description: 数组
 */
public class LC_2007_M_findOriginalArray {

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        LC_2007_M_findOriginalArray solution = new LC_2007_M_findOriginalArray();
        //1,3,4
        System.out.println(Arrays.toString(solution.findOriginalArray(changed)));
        int[] changed1 = {0,0,0,0};
        //0,0
        System.out.println(Arrays.toString(solution.findOriginalArray(changed1)));
    }

    /**
     * 查找原始数组。给定一个整数数组changed，其中的元素都是成对出现的，且每个元素都是changed中某个元素的两倍。找到原始数组original，其中original的元素满足original[i] * 2 = changed[i]，且original中的元素互不相同。
     *
     * @param changed 给定的已经改变的数组，其中的元素是成对出现的，且每个元素都是某个元素的两倍。
     * @return 返回原始数组，如果不存在满足条件的原始数组，则返回空数组。
     */
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed); // 对数组进行排序，以便后续处理。

        // 使用HashMap统计每个元素出现的次数。
        Map<Integer, Integer> count = new HashMap<>();
        for (int item : changed) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        int index = 0;
        int[] res = new int[n / 2]; // 假设原始数组的长度是已改变数组长度的一半。

        // 遍历数组，验证并构建原始数组。
        for (int item : changed) {
            if (count.getOrDefault(item, 0) == 0) continue; // 如果当前元素已经处理完毕，则跳过。

            count.put(item, count.getOrDefault(item, 0) - 1); // 对当前元素进行标记，表示已处理。

            // 如果当前元素的两倍在后续没有出现，则说明数组不满足条件，返回空数组。
            if (count.getOrDefault(item * 2, 0) == 0) {
                return new int[0];
            }

            count.put(item * 2, count.getOrDefault(item * 2, 0) - 1); // 对两倍元素进行标记，表示已处理。
            res[index++] = item; // 将当前元素添加到结果数组中。
        }

        return res;
    }
}
