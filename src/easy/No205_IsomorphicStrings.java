package easy;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 * 
 * @author lichenjie0522
 *
 */
public class No205_IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		HashMap<Character, Character> st = new HashMap<Character, Character>();
		HashMap<Character, Character> ts = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); ++i){
			if (st.containsKey(s.charAt(i)) && !st.get(s.charAt(i)).equals(t.charAt(i))){
				return false;
			} else if (ts.containsKey(t.charAt(i)) && !ts.get(t.charAt(i)).equals(s.charAt(i))){
				return false;
			} else {
				st.put(s.charAt(i), t.charAt(i));
				ts.put(t.charAt(i), s.charAt(i));
			}
		}
		return true;
	}
}
