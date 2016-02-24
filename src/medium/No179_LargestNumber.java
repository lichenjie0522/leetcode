package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author lichenjie0522
 *
 */
public class No179_LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			strNums[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strNums, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				String s1s2 = s1 + s2;
				String s2s1 = s2 + s1;
				return s2s1.compareTo(s1s2);
			}

		});
		if (strNums[0].equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String str : strNums) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(new No179_LargestNumber().largestNumber(nums));
	}
}
