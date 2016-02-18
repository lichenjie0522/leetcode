package easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * 要注意 zigSize = 2 * numSize - 2, zag = j + zigSize - 2 * i
 * 
 * @author lichenjie0522
 *
 */
public class No006_ZigZagConversion {
	public String convert(String s, int numRows) {
		int zigSize = 2 * numRows - 2;
		if (s == null || s.length() == 0 || zigSize <= 0) {
			return s;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numRows; ++i) {
			for (int j = i; j < s.length(); j+=zigSize) {
				result.append(s.charAt(j));
				if ( i != 0 && i != numRows - 1 && j + zigSize - 2 * i < s.length()) {
					result.append(s.charAt(j + zigSize - 2 * i));
				}
			}
		}
		return result.toString();
	}
}
