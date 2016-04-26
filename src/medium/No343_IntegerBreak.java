package medium;

/**
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 =
 * 3 + 3 + 4).
 * 
 * Note: you may assume that n is not less than 2.
 * 
 * Hint:
 * 
 * There is a simple O(n) solution to this problem. You may check the breaking
 * results of n ranging from 7 to 10 to discover the regularities.
 * 
 * @author lichenjie0522
 *
 */
public class No343_IntegerBreak {
	/*
	 * 发现规律 都是在3的倍数上进行拆分会得到最大乘机 2=1+1 p=1*1=1 3=2+1 p=2*1=2 4=2+2 p=2*2=4 5=3+2
	 * p=3*2=6 6=3+3 p=3*3=9 7=3+4 p=3*4=12 8=3+3+2 p=3*3*2=18 9=3+3+3
	 * p=3*3*3=27 10=3+3+4 p=3*3*4=36
	 */

	public int integerBreak(int n) {
		if (n < 4) {
			return n - 1;
		}
		int res = 1;
		while (n > 2) {// 看n包含多少个3,把他们相乘,直到n<=2
			res *= 3;
			n -= 3;
		}
		if (n == 1) {
			return (res / 3) * 4;// 除3余1，把其中的一个3加1变为4再相乘
		}
		if (n == 2) {
			return res * 2;// 除3余2,则可直接把2与res相乘
		}
		return res;
	}
}
