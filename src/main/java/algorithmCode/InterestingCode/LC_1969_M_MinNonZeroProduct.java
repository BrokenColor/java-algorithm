package algorithmCode.InterestingCode;

/**
 * 1969. 数组元素的最小非零乘积
 *
 * @Author bc
 * @Date 2024/3/20 22:20
 * @Description:
 */
public class LC_1969_M_MinNonZeroProduct {
    public static void main(String[] args) {
        LC_1969_M_MinNonZeroProduct lc_1969_M_MinNonZeroProduct = new LC_1969_M_MinNonZeroProduct();
        System.out.println(lc_1969_M_MinNonZeroProduct.minNonZeroProduct(3));
    }

    private long mod = 1000000007;

    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        //计算2的p次幂 -1 即数组包含的最大值
        long x = fastPow(2, p) - 1;
        long y = (long) 1 << (p - 1);
        //p: 1*1*...2的p次幂-2 * 2的p次幂-2 *...x
        //3：1*1*1 *6*6*6 * 7
        return (int) (fastPow(x - 1, y - 1) * x % mod);
    }

    /**
     * 该函数是计算x的n次幂的快速幂算法实现
     * 该函数的时间复杂度为O(logN)，空间复杂度为O(1)
     */
    public long fastPow(long x, long n) {
        long res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }
}
