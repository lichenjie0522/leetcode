package medium;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */
public class No069_Sqrtx {
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int low = 0, high = x;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid < x / mid) {
				low = mid + 1;
			} else if (mid > x / mid) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return high;
	}
}
