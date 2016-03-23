package medium;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author lichenjie0522
 *
 */
public class No005_LongestPalindromicSubstring {

	/**
	 * 中心展开法： 从头遍历数组，考虑Palindrome是奇数和偶数两种情况
	 * 
	 * Time Complexity - O(n2), Space Complexity - O(1)
	 * 
	 * @param s
	 * @return longestPalindrome
	 */
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String res = s.substring(0, 1);
		for (int i = 0; i < s.length(); ++i) {
			String tmp = getPalidrome(s, i, i);
			if (tmp.length() > res.length()) {
				res = tmp;
			}
			tmp = getPalidrome(s, i, i + 1);
			if (tmp.length() > res.length()) {
				res = tmp;
			}
		}
		return res;
	}

	private String getPalidrome(String s, int lo, int hi) {
		while (lo >= 0 && hi <= s.length() - 1 && s.charAt(lo) == s.charAt(hi)) {
			lo--;
			hi++;
		}
		return s.substring(lo + 1, hi);
	}

	/**
	 * Manacher: Time Complexity - O(n)， Space Complexity - O(n)
	 * 
	 * http://www.cnblogs.com/yrbbest/p/4430093.html
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] t = new char[s.length() * 2 + 1];
		int[] p = new int[t.length];
		preprocess(s, t);
		int center = 0, right = 0;
		for (int i = 1; i < t.length - 1; i++) {
			int mirror = 2 * center - i;
			if (i < right) {
				p[i] = Math.min(p[mirror], right - i);
			}
			while (i + p[i] < t.length && i - p[i] >= 0 && t[i + p[i]] == t[i - p[i]]) {
				p[i]++;
			}
			if (i + p[i] > right) {
				center = i;
				right = i + p[i];
			}
		}
		center = 0;
		int maxLen = 0;
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > maxLen) {
				center = i;
				maxLen = p[i];
			}
		}
		return s.substring((center - p[center] + 2) / 2, (center + p[center]) / 2);
	}

	private void preprocess(String s, char[] t) {
		for (int i = 0; i < s.length(); i++) {
			t[2 * i] = '#';
			t[2 * i + 1] = s.charAt(i);
		}
		t[t.length - 1] = '#';
	}
}
