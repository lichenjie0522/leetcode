package easy;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author lichenjie0522
 *
 */
public class No066_PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; --i) {
			int curDigit = digits[i];
			digits[i] = (curDigit + carry) % 10;
			carry = (curDigit + carry) >= 10 ? 1 : 0;
		}
		if (carry == 1) {
			int[] result = new int[digits.length + 1];
			result[0] = carry;
			for (int i = 1; i < result.length; ++i) {
				result[i] = digits[i - 1];
			}
			return result;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] digits = new int[1];
		System.out.println(new No066_PlusOne().plusOne(digits));
	}
}
