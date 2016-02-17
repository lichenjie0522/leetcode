package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * @author lichenjie0522
 *
 */
public class No202_HappyNumber {
	public boolean isHappy(int n) {
		if (n < 1) {
			return false;
		}
		long ln = n;
		Set<Long> appearedSet = new HashSet<Long>();
		while (ln <= Integer.MAX_VALUE) {
			if (!appearedSet.add(ln)) {
				return false;
			}
			ln = digitSquareSum(ln);
			if (ln == 1) {
				return true;
			}
		}
		return false;
	}
	
	private long digitSquareSum(long ln) {
		long sum = 0;
		while (ln > 0) {
			sum += Math.pow(ln%10, 2);
			ln /= 10;
		}
		return sum;
	}
	
}
