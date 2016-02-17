package medium;

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * @author lichenjie0522
 *
 */
public class No264_UglyNumberII {
	public static int nthUglyNumber(int n) {
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;
		int L2 = 0, L3 = 0, L5 = 0;
		for (int i = 1; i < n; ++i) {
			int a = uglyNumbers[L2] * 2;
			int b = uglyNumbers[L3] * 3;
			int c = uglyNumbers[L5] * 5;
			if (a <= b && a <= c) {
				uglyNumbers[i] = a;
				L2++;
			}
			if (b <= a && b <= c) {
				uglyNumbers[i] = b;
				L3++;
			}
			if (c <= a && c <= b) {
				uglyNumbers[i] = c;
				L5++;
			}
		}
		return uglyNumbers[n - 1];
	}
}
