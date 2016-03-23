package medium;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 * 
 * @author lichenjie0522
 *
 */
public class No260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return res;
		}
		int aXORb = 0;
		for (int i = 0; i < nums.length; ++i) {
			aXORb ^= nums[i];
		}
		// aXORb中必定至少有第k位为1，且a和b中只有一个数字的第k位为1
		int k = 0;
		for (int i = 0; i < 31; ++i) {
			if ((aXORb >> i & 1) == 1) {
				k = i;
				break;
			}
		}
		// 将数组中所有第k位为1的数异或，可以得到a
		int a = 0;
		for (int i = 0; i < nums.length; ++i) {
			if ((nums[i] >> k & 1) == 1) {
				a ^= nums[i];
			}
		}
		int b = a ^ aXORb;
		res[0] = a;
		res[1] = b;
		return res;
	}
}
