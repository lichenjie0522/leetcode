package easy;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author lichenjie0522
 *
 */
public class No165_CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null) {
			return 0;
		}
		String[] verArray1 = version1.split("\\.");
		String[] verArray2 = version2.split("\\.");
		int i = 0, j = 0;
		while (i < verArray1.length || j < verArray2.length) {
			int ver1 = i < verArray1.length ? Integer.parseInt(verArray1[i]) : 0;
			int ver2 = j < verArray2.length ? Integer.parseInt(verArray2[j]) : 0;
			if (ver1 < ver2) {
				return -1;
			} else if (ver1 > ver2) {
				return 1;
			} else {
				i++;
				j++;
			}
		}
		return 0;
	}
}
