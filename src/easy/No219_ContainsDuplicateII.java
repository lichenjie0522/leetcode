package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author lichenjie0522
 *
 */
public class No219_ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		int start = 0, end = 0;
		while (end < nums.length) {
			if (!set.add(nums[end++])) {
				return true;
			}
			if (end - start > k) {
				set.remove(nums[start++]);
			}
		}
		return false;
	}
}
