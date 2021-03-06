package easy;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author lichenjie0522
 *
 */
public class No027_RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != val) {
				nums[count++] = nums[i];
			}
		}
		return count;
	}
}
