package medium;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4,
 * 1, 5, 1, 6]. (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2,
 * 3, 1, 3, 1, 2].
 * 
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * @author lichenjie0522
 *
 */
public class No324_WiggleSortII {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int[] res = new int[nums.length];
		Arrays.sort(nums);
		int j = nums.length - 1;
		for (int i = 1; i < nums.length; i += 2, j--) {
			res[i] = nums[j];
		}
		for (int i = 0; i < nums.length; i += 2, j--) {
			res[i] = nums[j];
		}
		for (int i = 0; i < nums.length; ++i) {
			nums[i] = res[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 4, 6 };
		new No324_WiggleSortII().wiggleSort(nums);
		for (int i = 0; i < nums.length; ++i) {
			System.out.print(nums[i] + " ");
		}
	}
}
