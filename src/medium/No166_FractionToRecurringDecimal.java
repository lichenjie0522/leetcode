package medium;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2,
 * denominator = 1, return "2". Given numerator = 2, denominator = 3, return
 * "0.(6)".
 * 
 * @author lichenjie0522
 *
 */
public class No166_FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return null;
		}
		if (numerator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
			sb.append("-");
		}
		long num = Math.abs(Long.valueOf(numerator));
		long deno = Math.abs(Long.valueOf(denominator));
		sb.append(String.valueOf(num / deno));
		if (num % deno != 0) {
			long remainder = num % deno;
			sb.append(".");
			while (remainder > 0) {
				if (map.containsKey(remainder)) {
					sb.insert(map.get(remainder), "(");
					sb.append(")");
					break;
				}
				long quotient = remainder * 10 / deno;
				sb.append(quotient);
				map.put(remainder, sb.length() - 1);
				remainder = remainder * 10 % deno;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new No166_FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
	}
}
