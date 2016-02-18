package easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author lichenjie0522
 *
 */
public class No067_AddBinary {
	public String addBinary(String a, String b) {
		if (a == null && b == null) {
			return "0";
		}
		int aIndex = a.length() - 1, bIndex = b.length() - 1;
		int carry = 0, curSumDigit = 0;
		StringBuilder sb = new StringBuilder();
		while (aIndex >= 0 || bIndex >= 0) {
			int aValue = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
			int bValue = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;
			curSumDigit = (aValue + bValue + carry) % 2;
			sb.insert(0, curSumDigit);
			carry = (aValue + bValue + carry) >= 2 ? 1 : 0;
			aIndex--;
			bIndex--;
		}
		if (carry == 1){
			sb.insert(0, 1);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new No067_AddBinary().addBinary("11", "1"));
	}
}
