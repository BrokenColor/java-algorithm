package algorithmCode.InterestingCode;

/**
 * 42. 接雨水
 *
 * @author bc
 * @date 2023/06/23 22:55
 */
public class LC_42_H_Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        LC_42_H_Trap solution = new LC_42_H_Trap();
        System.out.println(solution.trap(height));
        System.out.println(solution.trap1(height));
        System.out.println(solution.trap2(height));
    }

    public int trap(int[] height) {
        int length = height.length;
        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            //找到左侧最大值
            for (int j = i - 1; j >= 0; j--) {
                if (maxLeft < height[j]) {
                    maxLeft = height[j];
                }
            }

            //找到右侧最大值
            for (int j = i + 1; j < length; j++) {
                if (maxRight < height[j]) {
                    maxRight = height[j];
                }
            }
            int min = Math.min(maxLeft, maxRight);
            //判断是大于当前列
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trap1(int[] height) {
        int length = height.length;
        //i位置左侧最大值
        int[] maxLeft = new int[length];
        //i位置右侧最大值
        int[] maxRight = new int[length];
        //计算出i位置左侧最大值
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        //计算出i位置右侧最大值
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            //左侧最大值与右侧最大值中小个一个
            int min = Math.min(maxLeft[i], maxRight[i]);
            //如果比当前列高
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int length = height.length;
        int sum = 0;
        int maxLeft = 0, maxRight = 0;
        int left = 1, right = length - 2;
        for (int i = 1; i < length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(height[left - 1], maxLeft);
                int min = maxLeft;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
            } else {//从右到左更
                maxRight = Math.max(height[right + 1], maxRight);
                int min = maxRight;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
