package easy;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * @author lichenjie0522
 *
 */
public class No189_RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null) {
			return;
		}
		int n = nums.length;
		if (n <= 1) {
			return;
		}
		k %= n;
		int[] tmp = new int[k];
		System.arraycopy(nums, n-k, tmp, 0, k);
		System.arraycopy(nums, 0, nums, k, n-k);
		System.arraycopy(tmp, 0, nums, 0, k);
	}
}
