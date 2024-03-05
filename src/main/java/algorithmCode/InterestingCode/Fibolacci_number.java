package algorithmCode.InterestingCode;

/**
 * 描述：菲波拉契数列问题
 * {斐波拉契数列原理：除开前两项 后面每位数等于前两项相加之和}
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 
 * @author BrokenColor
 * @date 2019年1月2日
 */
public class Fibolacci_number {

	public static void main(String[] args) {
		int f1 = 1, f2 = 1, f;
		int month = 24;
		System.out.println("第1月兔子 1 对");
		System.out.println("第2月兔子 1 对");
		// 从第三月起
		for (int i = 3; i < month; i++) {
			f = f2;
			f2 = f1 + f2;
			f1 = f;
			System.out.println("第" + i + "月兔子 " + f2 + " 对");
		}
	}

}
