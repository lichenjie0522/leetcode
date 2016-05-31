package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author lichenjie0522
 *
 */
public class No349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> res = new ArrayList<Integer>();
		int i = 0, j = 0;
		int n = nums1.length;
		int m = nums2.length;
		while (i != n && j != m) {
			if (nums1[i] == nums2[j]) {
				res.add(nums1[i]);
				while (++i != nums1.length && nums1[i] == nums1[i - 1])
					;
				while (++j != nums2.length && nums2[j] == nums2[j - 1])
					;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] ans = new int[res.size()];
		for (i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
}
