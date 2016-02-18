package easy;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author lichenjie0522
 *
 */
public class No028_ImplementStrStr {
	public int strStr_BruteForce(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			while (i + j < haystack.length() && j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
				if (j == needle.length())
					return i;
			}
		}
		return -1;
	}

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		int[] prefixTable = preProcess(needle);
		int i = 0, j = 0;
		int m = needle.length(), n = haystack.length();
		while (i < n) {
			if (needle.charAt(j) == haystack.charAt(i)) {
				if (j == m - 1) {
					return i - j;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = prefixTable[j - 1];
			} else {
				i++;
			}
		}
		return -1;
	}

	private int[] preProcess(String pattern) {
		int m = pattern.length();
		int[] prefixTable = new int[m];
		int i = 1, j = 0;
		while (i < m) {
			if (pattern.charAt(j) == pattern.charAt(i)) {
				prefixTable[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = prefixTable[j - 1];
			} else {
				prefixTable[i] = 0;
				i++;
			}
		}
		return prefixTable;
	}
}
