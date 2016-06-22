package medium;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 * 
 * @author lichenjie0522
 *
 */
public class No031_NextPermutation {

	/**
	 * 正常倒序应该是654321，假如652431，则2为inversion，并且next permutation应该为653124。
	 * 
	 * 方法是从后向前找inversion，找到第一个inversion，如上例中，然后继续从后向前判断，假如从数组尾部到inversion元素 i
	 * 间有数字大于i， 则swap i 和这个数字，由于swap之后依然是倒序，所以我们reverse i 到 nums.length -1。
	 * 
	 * Time Complexity - O(n)， Space Complexity - O(1)。
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				for (int j = nums.length - 1; j >= i; j--) {
					if (nums[i] < nums[j]) {
						swap(nums, i, j);
						reverse(nums, i + 1, nums.length - 1);
						return;
					}
				}
			}
		}
		reverse(nums, 0, nums.length - 1);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int lo, int hi) {
		while (lo < hi) {
			swap(nums, lo++, hi--);
		}
	}
}
