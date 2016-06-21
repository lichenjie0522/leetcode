package medium;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * @author lichenjie0522
 *
 */
public class No151_ReverseWordsInAString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] carr = s.toCharArray();
		int start = 0, end = carr.length - 1;
		// trim start
		while (start <= end && carr[start] == ' ') {
			start++;
		}
		// trim end
		while (end >= 0 && carr[end] == ' ') {
			end--;
		}
		if (start > end) {
			return new String("");
		}
		int i = start;
		while (i <= end) {
			if (carr[i] != ' ') {
				// case when i points to the start of a word, find the end and
				// reverse it
				int j = i + 1;
				while (j <= end && carr[j] != ' ') {
					j++;
				}
				reverse(carr, i, j - 1);
				i = j;
			} else {
				if (carr[i - 1] == ' ') {
					// case when prev char is also space, shift the remaining
					// string
					// to left and decrease by 1
					int j = i;
					while (j <= end - 1) {
						carr[j] = carr[j + 1];
						j++;
					}
					end--;
				} else {
					// case when there is just a single space
					i++;
				}
			}
		}
		reverse(carr, start, end);
		return new String(carr, start, end - start + 1);
	}

	private static void reverse(char[] carr, int start, int end) {
		while (start < end) {
			char tmp = carr[start];
			carr[start] = carr[end];
			carr[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(new No151_ReverseWordsInAString().reverseWords("  a   b  "));
	}
}
