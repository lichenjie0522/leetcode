package medium;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author lichenjie0522
 *
 */
public class No053_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int globalMax = Integer.MIN_VALUE;
		int localMax = 0;
		for (int i = 0; i < nums.length; i++) {
			localMax += nums[i];
			globalMax = Math.max(globalMax, localMax);
			if (localMax < 0) {
				localMax = 0;
			}
		}
		return globalMax;
	}
}
