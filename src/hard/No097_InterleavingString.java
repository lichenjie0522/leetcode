package hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * 假设我们构建一个棋盘，s1代表行，s2代表列，每次只能向右或者向下走，最后看s3这条路径能不能够从左上到达右下。
 * 
 * @author lichenjie0522
 *
 */
public class No097_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return true;
		}
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		for (int i = 0; i < len1 + 1; ++i) {
			for (int j = 0; j < len2 + 1; ++j) {
				if (dp[i][j] == true || j - 1 >= 0 && dp[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(i + j - 1)
						|| i - 1 >= 0 && dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[len1][len2];
	}
}
