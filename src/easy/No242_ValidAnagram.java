package easy;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * @author lichenjie0522
 *
 */
public class No242_ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}
		int[] bitMap = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			bitMap[s.charAt(i) - 'a']++;
			bitMap[t.charAt(i) - 'a']--;
		}
		for (int i : bitMap) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
