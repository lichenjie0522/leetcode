package hard;

import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author lichenjie0522
 *
 */
public class No128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		int max = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
				int localMax = 1;
				int left = nums[i] - 1;
				int right = nums[i] + 1;
				while (set.contains(left)) {
					set.remove(left);
					localMax++;
					left--;
				}
				while (set.contains(right)) {
					set.remove(right);
					localMax++;
					right++;
				}
				max = Math.max(max, localMax);
			}
		}
		return max;
	}
}
