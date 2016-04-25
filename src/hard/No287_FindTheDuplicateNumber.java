package hard;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 * 
 * @author lichenjie0522
 *
 */
public class No287_FindTheDuplicateNumber {

	//快慢指针技巧，和链表找环一样的处理方式
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
