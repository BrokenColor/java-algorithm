package algorithmCode.base;

import java.util.Arrays;

/**
 * 描述：选择排序
 * 
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 * 
 * @author BrokenColor
 * @date 2019年4月1日
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 8, 7, 9, 5, 6, 4, 7, 2, 5, 3, 7, 5 };
		SelectionSort quickSort = new SelectionSort();
		quickSort.method(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void method(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index =i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index =j;////将最小数的索引保存
				}
			}
			//把最小数的交换到前面
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
}
