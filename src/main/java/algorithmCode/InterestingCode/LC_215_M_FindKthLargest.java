package algorithmCode.InterestingCode;

/**
 * 215.数组中的第k个最大元素
 *
 * @Author bc
 * @Date 2024/3/10 23:18
 * @Description:
 */
public class LC_215_M_FindKthLargest {
    public static void main(String[] args) {
        LC_215_M_FindKthLargest solution = new LC_215_M_FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        //快速排序，找到第length-k的元素
        return quickSort(nums, 0, length - 1, length - k);
    }

    //快速排序
    private int quickSort(int[] nums, int left, int right, int index) {
        if (left <= right) {
            //找到基准元素
            int p = partation(nums, left, right);
            //如果基准元素是要找index则返回
            if (p == index) {
                return nums[p];
            } else if (p < index) {//基准p小于index 则找数组右边
                return quickSort(nums, p + 1, right, index);
            } else if (p > index) {//基准p大于index 则找数组做边
                return quickSort(nums, left, p - 1, index);
            }
        }
        return -1;
    }

    private int partation(int[] nums, int left, int right) {
        int p = left;//取left为基准元素下标
        int index = p + 1; //用于标记需要交换的下标（类似与快慢指针中的慢指针）
        for (int i = index; i <= right; i++) {
            if (nums[p] > nums[i]) {//当i元素小于基准的时候，
                swap(nums, i, index);//交换i，index元素值（类似交换快慢指针的值）
                index++;
            }
        }
        //最后需要交换 基准跟index元素的值，因为在上面循环中index进行了++，所以此处需要交换index-1
        swap(nums, p, index - 1);
        //返回基准下标
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
