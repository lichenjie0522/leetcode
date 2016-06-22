package hard;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author lichenjie0522
 *
 */
public class No214_ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		// pre-process
		char[] t = new char[s.length() * 2 + 1];
		for (int i = 0; i < s.length(); i++) {
			t[2 * i] = '#';
			t[2 * i + 1] = s.charAt(i);
		}
		t[t.length - 1] = '#';

		// manacher
		int[] p = new int[t.length];
		int center = 0, right = 0;
		for (int i = 1; i < t.length - 1; i++) {
			// find the mirror of i
			int mirror = 2 * center - i;
			// if i is in the range of right border, then update the p[i]
			if (right > i) {
				p[i] = Math.min(right - i, p[mirror]);
			}
			// expand p[i]
			while (i - p[i] >= 0 && i + p[i] < t.length && t[i - p[i]] == t[i + p[i]]) {
				p[i]++;
			}
			// update right border and center
			if (i + p[i] > right) {
				right = i + p[i];
				center = i;
			}
		}
		center = 0;
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] == i + 1) {
				center = i;
			}
		}
		return new StringBuilder(s.substring((center + p[center]) / 2)).reverse().toString() + s;
	}
}
