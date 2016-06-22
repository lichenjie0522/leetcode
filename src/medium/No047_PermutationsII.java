package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 * 
 * @author lichenjie0522
 *
 */
public class No047_PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		List<Integer> onePerm = new ArrayList<Integer>();
		permute(res, onePerm, visited, nums);
		return res;
	}

	private void permute(List<List<Integer>> res, List<Integer> onePerm, boolean[] visited, int[] nums) {
		if (onePerm.size() == nums.length) {
			res.add(new ArrayList<Integer>(onePerm));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
				continue;
			}
			visited[i] = true;
			onePerm.add(nums[i]);
			permute(res, onePerm, visited, nums);
			onePerm.remove(onePerm.size() - 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 4 };
		List<List<Integer>> res = new No047_PermutationsII().permuteUnique(nums);
		res.stream().forEach(i -> System.out.println(i));
	}
}
