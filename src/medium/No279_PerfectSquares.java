package medium;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * @author lichenjie0522
 *
 */
public class No279_PerfectSquares {

	public int numSquares(int n) {
		if (n < 1) {
			return 0;
		}
		int[] min = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			int leastNum = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; ++j) {
				leastNum = Math.min(leastNum, min[i - j * j] + 1);
			}
			min[i] = leastNum;
		}
		return min[n];
	}
}
