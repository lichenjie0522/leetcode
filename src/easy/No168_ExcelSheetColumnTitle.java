package easy;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author lichenjie0522
 *
 */
public class No168_ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.insert(0, (char) (n % 26 + 'A'));
			n /= 26;
		}
		return sb.toString();
	}
}
