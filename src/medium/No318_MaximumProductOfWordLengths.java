package medium;

/**
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The
 * two words can be "ab", "cd".
 * 
 * Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
 * 
 * @author lichenjie0522
 *
 */
public class No318_MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		int[] wordBitMap = new int[words.length];
		for (int i = 0; i < words.length; ++i) {
			for (char c : words[i].toCharArray()) {
				wordBitMap[i] |= (1 << (c - 'a'));
			}
		}
		int max = 0;
		for (int i = 0; i < words.length; ++i) {
			for (int j = i + 1; j < words.length; ++j) {
				if ((wordBitMap[i] & wordBitMap[j]) == 0) {
					int tmp = words[i].length() * words[j].length();
					max = max < tmp ? tmp : max;
				}
			}
		}
		return max;
	}
}
