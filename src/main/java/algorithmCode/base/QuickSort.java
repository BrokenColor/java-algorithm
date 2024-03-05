package algorithmCode.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 描述：快速排序
 * <p>
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
 *
 * @author BrokenColor
 * @date 2019年3月26日
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 8, 7, 9, 5, 6, 4, 7, 2, 5, 3, 7, 5};
        QuickSort quickSort = new QuickSort();
//		quickSort.quickSortRecursion(arr,0,arr.length-1);
        quickSort.quickSortStack(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //递归的方式
    public void quickSortRecursion(int[] arr, int startIndex, int endIndex) {
        //// 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex > endIndex) {
            return;
        }
        // 得到基准元素位置（两种方式）
//		int pivotIndex = position(arr, startIndex, endIndex);
        int pivotIndex = position1(arr, startIndex, endIndex);
        // 用分治法递归数列的两部分
        quickSortRecursion(arr, pivotIndex + 1, endIndex);
        quickSortRecursion(arr, startIndex, pivotIndex - 1);

    }

    //栈的方式
    public void quickSortStack(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap<>(16);
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);
        // 循环结束条件：栈为空时结束
        while (!quickSortStack.isEmpty()) {
            //// 栈顶元素出栈，得到起止下标
            Map<String, Integer> params = quickSortStack.pop();
            // 得到基准元素位置（两种方式）
//			int pivotIndex = position(arr, startIndex, endIndex);
            int pivotIndex = position1(arr, params.get("startIndex"), params.get("endIndex"));
            //根据基准元素分成两部分, 把每一部分的起止下标入栈==>右侧
            if (pivotIndex - 1 > params.get("startIndex")) {
                Map<String, Integer> leftparam = new HashMap<>(16);
                leftparam.put("startIndex", params.get("startIndex"));
                leftparam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftparam);
            }
            //左边
            if (pivotIndex + 1 < params.get("endIndex")) {
                Map<String, Integer> rightparam = new HashMap<>(16);
                rightparam.put("startIndex", pivotIndex + 1);
                rightparam.put("endIndex", params.get("endIndex"));
                quickSortStack.push(rightparam);
            }
        }
    }

    //找到基准的位置
    public int position(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        // 基准的位置，初始等于pivot的位置
        int index = startIndex;
        int right = endIndex;
        int left = startIndex;
        //大循环在左右指针重合或者交错时结束
        while (left <= right) {
            //right指针从右向左进行比较
            while (left <= right) {
                if (pivot >= arr[right]) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (left <= right) {
                if (pivot < arr[left]) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }

    //指针交换法
    public int position1(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            //控制right指针比较并左移
            while (left < right && pivot < arr[right]) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if (left < right) {
                int p = arr[right];
                arr[right] = arr[left];
                arr[left] = p;
            }
        }
        //pivot和指针重合点交换
        int p = arr[startIndex];
        arr[startIndex] = arr[left];
        arr[left] = p;
        return left;
    }
}

class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort1 quickSort = new QuickSort1();
        System.out.println(Arrays.toString(quickSort.sort(arr)));
    }

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}