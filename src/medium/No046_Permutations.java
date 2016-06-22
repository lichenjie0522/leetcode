package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author lichenjie0522
 *
 */
public class No046_Permutations {

	/**
	 * DFS + backtracking(使用list.contains去重复):
	 * 
	 * 我们也可以用DFS+Backtracking来做。这里需要建立一个helper函数permute和一个辅助List
	 * <Integer> onePerm。当onePerm.size() ==
	 * nums.size()的时候，我们把这个辅助list加入到结果中。否则我们进行从0到nums.length -
	 * 1的遍历，在这个遍历过程中我们使用了DFS+回溯。我们假设给定nums中不含重复元素，
	 * 一个重要的去重步骤是，假如当前辅助List里已经有nums[i]了，那么我们进行跳过。这一步使用了O(n)的复杂度，所以导致整个过程比较慢。
	 * 
	 * Time Complexity - O(n!)， Space Complexity O(n)。
	 * (其实由于有这一步list.contains()递归复杂度应该是 (n * 1) *((n - 1) * 2) *((n - 2) *
	 * 3)...)应该等于 ∏(12*..。 *n2)
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		List<Integer> onePerm = new ArrayList<Integer>();
		permute(res, onePerm, nums);
		return res;
	}

	private void permute(List<List<Integer>> res, List<Integer> onePerm, int[] nums) {
		if (onePerm.size() == nums.length) {
			res.add(new ArrayList<Integer>(onePerm));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (onePerm.contains(nums[i])) {
				continue;
			}
			onePerm.add(nums[i]);
			permute(res, onePerm, nums);
			onePerm.remove(onePerm.size() - 1);
		}
	}
}
