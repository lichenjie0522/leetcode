package medium;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author lichenjie0522
 *
 */
public class No153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int i = 0, j = nums.length - 1;
		while (i < j && nums[i] > nums[j]) {
			int mid = i + (j - i) / 2;
			if (nums[mid] > nums[j]) {
				i = mid + 1; //不+1就死循环了
			} else {
				j = mid;
			}
		}
		return nums[i];
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(new No153_FindMinimumInRotatedSortedArray().findMin(nums));
	}
}
