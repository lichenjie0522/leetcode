package easy;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * 每找出两个不同的element，则成对删除。最终剩下的一定就是所求的。 可扩展到⌊ n/k ⌋的情况，每k个不同的element进行成对删除。
 * 
 * @author lichenjie0522
 *
 */
public class No169_MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int candidate = 0, count = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (count == 0) {
				candidate = nums[i];
				count++;
			} else {
				count = nums[i] == candidate ? count + 1 : count - 1;
			}
		}
		return candidate;
	}
}
