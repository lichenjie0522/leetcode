package easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author lichenjie0522
 *
 */
public class No058_LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int count = 0;
		if (s == null || s.length() == 0) {
			return count;
		}
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) == ' ') {
				if (count == 0) {
					continue;
				} else {
					break;
				}
			}
			count++;
		}
		return count;
	}
	
	public int lengthOfLastWord1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (!s.contains(" ")) {
			return s.length();
		}
		String[] arrStr = s.split(" ");
		if (arrStr.length < 1) {
			return 0;
		}
		String lastWord = arrStr[arrStr.length - 1];
		return lastWord.length();
	}
	
	public static void main(String[] args) {
		System.out.println(new No058_LengthOfLastWord().lengthOfLastWord(" "));
	}
}
