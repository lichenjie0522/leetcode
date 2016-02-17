package medium;

/**
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author lichenjie0522
 *
 */
public class No213_HouseRobberII {
	public int rob(int[] nums) {
		int n = nums.length;
		if (nums == null || n < 1) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
	}

	private int robRange(int[] nums, int start, int end) {
		int n = end - start + 1;
		int[] maxValues = new int[n];
		maxValues[0] = nums[start];
		maxValues[1] = Math.max(nums[start], nums[start + 1]);
		for (int i = 2; i < n; ++i) {
			maxValues[i] = Math.max(maxValues[i-2] + nums[start + i], maxValues[i-1]);
		}
		return maxValues[n-1];
	}
}
