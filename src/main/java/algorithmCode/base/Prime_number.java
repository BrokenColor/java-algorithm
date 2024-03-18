package algorithmCode.base;

/**
 * 描述：判断101-200之间有多少个素数，并输出所有素数。 
 * 分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。、
 * 
 * @author BrokenColor
 * @date 2019年1月2日
 */
public class Prime_number {

	public static void main(String[] args) {
		int count = 0;
		//被除数可以每次增加2个
		for (int i = 101; i < 200; i += 2) {
			boolean flag = true;
			//除数只用算一半
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
				System.out.println("素数：" + i);
			}
		}
		System.out.println("101-200之间有素数:" + count + "个");

		System.out.println(prime(100));
	}

	//n以内的素数个数
	public static int prime(int n){
		//记录ture为合数，false为素数
		boolean[] primes = new boolean[n];
		int count = 0;
		//0，1 除外，从2开始遍历
		for (int i = 2; i < n; i++) {
			if (!primes[i]){
				count++;
				for (int j = i * i; j < n; j += i) {
					primes[j] = true;//为合数
				}
			}

		}
		return count;
	}

}
