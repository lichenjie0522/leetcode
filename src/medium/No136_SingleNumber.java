package medium;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author lichenjie0522
 *
 */
public class No136_SingleNumber {
	public int singleNumber(int[] nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			result ^= nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3, 3, 5 };
		System.out.println(new No136_SingleNumber().singleNumber(nums));
	}
}
