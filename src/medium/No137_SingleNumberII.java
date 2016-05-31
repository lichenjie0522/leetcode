package medium;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author lichenjie0522
 *
 */
public class No137_SingleNumberII {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] count = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) > 0) {
					count[i]++;
				}
			}
			res |= (count[i] % 3) << i;
		}
		return res;
	}
}
