package medium;

/**
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 * 
 * For example: Given n = 13, Return 6, because digit 1 occurred in the
 * following numbers: 1, 10, 11, 12, 13.
 * 
 * n < 1时，结果为0 1 <= n < 10时，结果为1 假定n = 312，我们把这个计算过程分解为几个步骤: (1 ~ 99)， 结果为
 * countDigitOne(99) (100 ~ 199)， 结果为 100 + countDigitOne(99) (200 ~ 299)，
 * 结果为countDigitOne(99) (300 ~ 312)， 结果为countDigitOne(12) 假定n = 112，
 * 我们也把这个计算过程分解一下: (1 ~ 99)， 结果为 countDigitOne(99) (100 ~ 112)， 结果为 112 - 100 +
 * 1 + countDigitOne(12) 由此我们可以推出通项公式
 * 
 * @author lichenjie0522
 *
 */
public class No233_NumberOfDigitOne {
	public int countDigitOne(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n < 10) {
			return 1;
		}
		int baseInTen = (int) Math.pow(10, String.valueOf(n).length() - 1);
		int highestDigit = n / baseInTen;
		if (highestDigit == 1) {
			return countDigitOne(baseInTen - 1) + (n - baseInTen + 1) + countDigitOne(n % baseInTen);
		} else {
			return highestDigit * countDigitOne(baseInTen - 1) + baseInTen + countDigitOne(n % baseInTen);
		}
	}
}
