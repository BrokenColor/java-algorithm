package algorithmCode.InterestingCode;

/**
 * 11.盛最多水的容器
 *
 * @author bc
 * @date 2021/12/4 18:25
 * 左右双指针
 */
public class LC_11_M_MaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        //左右双指针移动
        for (int i = 0; i < height.length; i++) {
            int tempArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(tempArea, maxArea);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
