package medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * Greedy贪婪法。维护一个maxCover，对数组从0 - maxCover或者nums.length进行遍历。当maxCover >=
 * nums.length - 1时表示可以跳到最后一个元素
 * 
 * @author lichenjie0522
 *
 */
public class No055_JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int maxCoverPos = 0;
		for (int i = 0; i < nums.length && i <= maxCoverPos; ++i) {
			if (maxCoverPos < i + nums[i]) {
                maxCoverPos = i + nums[i];
            }
			if (maxCoverPos >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}
}
