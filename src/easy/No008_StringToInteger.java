package easy;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author lichenjie0522
 *
 */
public class No008_StringToInteger {

	public static int myAtoi(String str) {
		long res = 0;
		boolean isPositive = true;
		int index = 0;
		if (str == null || str.equals("")) {
			return 0;
		}
		while (str.charAt(index) == ' ' && index < str.length()) {
			index++;
		}
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			isPositive = str.charAt(index) == '+' ? true : false;
			index++;
			if (isPositive && index < str.length() && str.charAt(index) == '-') {
				return 0;
			}
			if (!isPositive && index < str.length() && str.charAt(index) == '+') {
				return 0;
			}
		} else if (str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9) {
			isPositive = true;
		} else {
			return 0;
		}
		while (index < str.length() && str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9) {
			int digit = str.charAt(index) - '0';
			res = res * 10 + digit;
			index++;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				res = isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
		}
		if (!isPositive) {
			res = -res;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		String str = "+";
		System.err.println(myAtoi(str));
	}
}
