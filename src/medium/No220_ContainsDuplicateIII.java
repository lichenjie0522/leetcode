package medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author lichenjie0522
 *
 */
public class No220_ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || k < 1 || t < 0 || nums.length < 2) {
            return false;
        }
		SortedSet<Long> set = new TreeSet<Long>();
		int start = 0, end = 0;
		while (end < nums.length) {
			SortedSet<Long> subSet = set.subSet((long)nums[end] - t, (long)nums[end] + t + 1);
			if (!subSet.isEmpty()) {
				return true;
			}
			if (end - start > k) {
				set.remove((long)nums[start++]);
			}
			set.add((long)nums[end++]);
		}
		return false;
	}
}
