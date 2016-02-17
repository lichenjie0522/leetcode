package medium;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val. Example: Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8 Note: The array is only
 * modifiable by the update function. You may assume the number of calls to
 * update and sumRange function is distributed evenly.
 * 
 * reference:
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * http://www.cnblogs.com/yrbbest/p/5056739.html
 * 
 * @author lichenjie0522
 *
 */
public class No307_RangeSumQueryMutable {

	private int[] nums;
	private int[] BIT;

	public No307_RangeSumQueryMutable(int[] nums) {
		this.nums = nums;
		BIT = new int[nums.length + 1];
		for (int i = 0; i < nums.length; ++i) {
			init(i + 1, nums[i]);
		}
	}

	private void init(int i, int val) {
		while (i < BIT.length) {
			BIT[i] += val;
			i = i + (i & -i);
		}
	}

	void update(int i, int val) {
		int delta = val - nums[i];
		nums[i] = val;
		init(i + 1, delta);
	}

	public int sumRange(int i, int j) {
		return getSum(j + 1) - getSum(i);
	}

	private int getSum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += BIT[i];
			i = i - (i & -i);
		}
		return sum;
	}
}
