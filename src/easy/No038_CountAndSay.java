package easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author lichenjie0522
 *
 */
public class No038_CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		int count = 1;
		String result = "1";
		StringBuilder sb = new StringBuilder();
		int start = 1;
		while (start < n) {
			for (int i = 1; i < result.length(); ++i) {
				if (result.charAt(i) == result.charAt(i - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(i - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			sb.setLength(0); // important
			start++;
			count = 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new No038_CountAndSay().countAndSay(4));
	}
}
