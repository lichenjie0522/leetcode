package easy;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author lichenjie0522
 *
 */
public class No198_HouseRobber {
	public int rob(int[] nums) {
		int n = nums.length;
		if (nums == null || n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		int[] maxValue = new int[nums.length];
		maxValue[0] = nums[0];
		maxValue[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; ++i) {
			maxValue[i] = Math.max(maxValue[i - 2] + nums[i], maxValue[i - 1]);
		}
		return maxValue[n - 1];
	}
}
