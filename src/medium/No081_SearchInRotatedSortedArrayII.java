package medium;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author lichenjie0522
 *
 */
public class No081_SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int left = 0, right = nums.length - 1;
		return search(nums, left, right, target);
	}

	//有重复则为o(n)，无重复o(logn)
	//先找出正常升序的那一半，若有重复的则两边都需要查找
	private boolean search(int[] nums, int left, int right, int target) {
		if (left > right) {
			return false;
		}
		int mid = left + (right - left) / 2;
		if (target == nums[mid]) {
			return true;
		}
		if (nums[left] < nums[mid]) {
			if (nums[left] <= target && target <= nums[mid]) {
				return search(nums, left, mid - 1, target);
			} else {
				return search(nums, mid + 1, right, target);
			}
		} else if (nums[left] > nums[mid]) {
			if (nums[mid] <= target && target <= nums[right]) {
				return search(nums, mid + 1, right, target);
			} else {
				return search(nums, left, mid - 1, target);
			}
		} else if (nums[left] == nums[mid]) {
			if (nums[mid] != nums[right]) {
				return search(nums, mid + 1, right, target);
			} else {
				boolean result = search(nums, left, mid - 1, target);
				if (result == false) {
					return search(nums, mid + 1, right, target);
				} else {
					return result;
				}
			}
		}
		return false;
	}
}
