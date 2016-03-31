package medium;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author lichenjie0522
 *
 */
public class No003_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 0, start = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= start) {
				start = map.get(c) + 1;
			}
			map.put(c, i);
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}
