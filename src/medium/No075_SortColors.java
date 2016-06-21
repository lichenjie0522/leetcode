package medium;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author lichenjie0522
 *
 */
public class No075_SortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int[] countArr = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countArr[nums[i]]++;
		}
		int k = 0;
		for (int i = 0; i < 3; i++) {
			if (countArr[i] == 0) {
				continue;
			}
			for (int j = 0; j < countArr[i]; j++, k++) {
				nums[k] = i;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0 };
		new No075_SortColors().sortColors(nums);
		for (int i = 0; i < nums.length; i ++) {
			System.out.println(nums[i]);
		}
	}
}
