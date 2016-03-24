package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤
 * b ≤ c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * 3指针夹逼，注意去重
 * 
 * @author lichenjie0522
 *
 */
public class No015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; ++i) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum == 0) {
					List<Integer> triplet = new ArrayList<Integer>();
					triplet.add(nums[i]);
					triplet.add(nums[lo]);
					triplet.add(nums[hi]);
					res.add(triplet);
					lo++;
					hi--;
					while (lo < hi && nums[lo] == nums[lo - 1]) {
						lo++;
					}
					while (lo < hi && nums[hi] == nums[hi + 1]) {
						hi--;
					}
				} else if (sum < 0) {
					lo++;
				} else {
					hi--;
				}
			}
		}
		return res;
	}
}
