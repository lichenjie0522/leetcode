package medium;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class No001_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (!map.containsKey(target - nums[i])) {
				map.put(nums[i], i);
			} else {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				break;
			}
		}
		return res;
	}
}
