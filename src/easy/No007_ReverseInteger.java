package easy;

/**
 * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x =
 * -123, return -321
 * 
 * @author lichenjie0522
 *
 */
public class No007_ReverseInteger {
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = x % 10 + res * 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
			x /= 10;
		}
		return (int) res;
	}
}
