package medium;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author lichenjie0522
 *
 */
public class No034_SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = getBoundRange(nums, 0, nums.length - 1, target, true);
		result[1] = getBoundRange(nums, 0, nums.length - 1, target, false);
		return result;
	}

	public int getBoundRange(int[] A, int l, int r, int target, boolean left) {
		if (l > r) {
			return -1;
		}
		int mid = l + (r - l) / 2;
		if (A[mid] == target) {
			if (left) {
				if (mid == 0 || A[mid - 1] < target) {
					return mid;
				} else {
					return getBoundRange(A, l, mid - 1, target, left);
				}
			} else {
				if (mid == A.length - 1 || A[mid + 1] > target) {
					return mid;
				} else {
					return getBoundRange(A, mid + 1, r, target, left);
				}
			}
		} else if (A[mid] > target) {
			return getBoundRange(A, l, mid - 1, target, left);
		} else {
			return getBoundRange(A, mid + 1, r, target, left);
		}
	}
}
