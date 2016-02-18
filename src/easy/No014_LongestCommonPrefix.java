package easy;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author lichenjie0522
 *
 */
public class No014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		for (int j = 0; j < strs[0].length(); ++j) {
			for (int i = 1; i < strs.length; ++i) {
				if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) { //注意j与长度的判断要先做，否则charAt出错
					return strs[0].substring(0, j);
				}
			}
		}
		return strs[0];
	}
}
