package algorithmCode.base;

import java.util.Arrays;

/**
 * 描述：冒泡排序
 * 
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * 
 * @author BrokenColor
 * @date 2019年4月1日
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {4,2,8,7,5,2,0,6,3,7,9,4,3};
		BubbleSort bs = new BubbleSort();
//		bs.method(arr);
		bs.method1(arr);
		System.out.println(Arrays.toString(arr));
	}
	//第一种方式（第i个数依次与后面的数进行对比，大于就置换）小数移到前面
	public void method(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	//第二种方式（第j个数与后一位进行对比，大于就置换）大数移到后面
	public void method1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
