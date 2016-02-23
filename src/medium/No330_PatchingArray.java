package medium;

/**
 * Given a sorted positive integer array nums and an integer n, add/patch
 * elements to the array such that any number in range [1, n] inclusive can be
 * formed by the sum of some elements in the array. Return the minimum number of
 * patches required.
 * 
 * Example 1: nums = [1, 3], n = 6 Return 1.
 * 
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3,
 * 4. Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3],
 * [2,3], [1,2,3]. Possible sums are 1, 2, 3, 4, 5, 6, which now covers the
 * range [1, 6]. So we only need 1 patch.
 * 
 * Example 2: nums = [1, 5, 10], n = 20 Return 2. The two patches can be [2, 4].
 * 
 * Example 3: nums = [1, 2, 2], n = 5 Return 0.
 * 
 * 
 * cur表示当前能表示的范围为[1..cur],扫描nums[ ]，贪心原则如下： 若nums[i]<=cur +
 * 1,把nums[i]添加进来，表示范围更新[1..cur+nums[i]]; 若nums[i]>cur +
 * 1,添加新的元素cur+1,表示范围更新[1..2*cur+1]. cur从0开始
 * 
 * @author lichenjie0522
 *
 */
public class No330_PatchingArray {
	public int minPatches(int[] nums, int n) {
		int addition = 0;
		long curCoverRange = 0;
		int index = 0;
		while (curCoverRange < n) {
			if (index < nums.length && nums[index] <= curCoverRange + 1) {
				curCoverRange += nums[index++];
			} else {
				addition++;
				curCoverRange = 2 * curCoverRange + 1;
			}
		}
		return addition;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 10};
		System.out.println(new No330_PatchingArray().minPatches(nums, 20));
	}
}
