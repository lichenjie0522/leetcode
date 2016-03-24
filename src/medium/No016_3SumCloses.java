package medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 三指针夹逼o(n2)
 * 
 * @author lichenjie0522
 *
 */
public class No016_3SumCloses {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int diff = Integer.MAX_VALUE;
		int left, right, result = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; ++i) {
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				if (Math.abs(sum - target) < diff) {
					diff = Math.abs(sum - target);
					result = sum;
				}
			}
		}
		return result;
	}
}
