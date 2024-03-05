package algorithmCode.InterestingCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author guwanli
 * @date 2021/12/5 20:46
 */
public class LC_84_H_LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        LC_84_H_LargestRectangleArea area = new LC_84_H_LargestRectangleArea();
        System.out.println(area.largestRectangleArea(heights));
    }

    //双指针从中间向两边处理
//    public int largestRectangleArea(int[] heights) {
//        int result = 0, len = heights.length;
//        if (len < 1) {
//            return result;
//        } else if (len == 1) {
//            return heights[0];
//        }
//
//        for (int i = 0; i < len; i++) {
//            int left = i, right = i;
//            while (left > 0 && heights[left - 1] >= heights[i]) left--;
//            while (right < len - 1 && heights[right + 1] >= heights[i]) right++;
//            int temp = heights[i] * (right - left + 1);
//            result = Math.max(temp, result);
//        }
//        return result;
//    }

    //用栈的方式处理
    public int largestRectangleArea(int[] heights) {
        int result = 0, len = heights.length;
        if (len < 1) {
            return result;
        } else if (len == 1) {
            return heights[0];
        }
        //存储i位置右边界的坐标
        int[] right = new int[len];
        //存储i位置左边界的坐标
        int[] left = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        //根据left和right边界计算面积
        for (int i = 0; i < len; i++) {
            int temp = heights[i] * (right[i] - left[i] - 1);
            result = Math.max(temp, result);
        }
        return result;
    }
}
