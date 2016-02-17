package easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * 对n!做质因数分解n!=2x*3y*5z*...
 * 
 * 显然0的个数等于min(x,z)，并且min(x,z)==z
 * 
 * 证明：
 * 
 * 对于阶乘而言，也就是1*2*3*...*n [n/k]代表1~n中能被k整除的个数 那么很显然 [n/2] > [n/5]
 * (左边是逢2增1，右边是逢5增1) [n/2^2] > [n/5^2](左边是逢4增1，右边是逢25增1) …… [n/2^p] >
 * [n/5^p](左边是逢2^p增1，右边是逢5^p增1) 随着幂次p的上升，出现2^p的概率会远大于出现5^p的概率。
 * 因此左边的加和一定大于右边的加和，也就是n!质因数分解中，2的次幂一定大于5的次幂
 * 
 * @author lichenjie0522
 *
 */
public class No172_FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		if (n <= 0) {
			return 0;
		}
		int result = 0;
		while (n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}
}
