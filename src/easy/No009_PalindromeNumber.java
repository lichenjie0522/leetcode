package easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author lichenjie0522
 *
 */
public class No009_PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int digitNum = (int)Math.log10(x);
		int left = 0, right = 0;
		while (x > 0) {
			int powInTens = (int) Math.pow(10, digitNum);
			left = x / powInTens;
			right = x % 10;
			if (left != right) {
				return false;
			}
			x -= left * powInTens;
			x /= 10;
			digitNum -= 2;
		}
		return true;
	}

	public boolean isPalindrome1(int x) {
		if (x == 0) {
			return true;
		}
		int tmp = x, result = 0;
		while (tmp > 0) {
			result = result * 10 + tmp % 10;//result * 10 may overflow
			tmp /= 10;
		}
		return result == x;
	}
}
