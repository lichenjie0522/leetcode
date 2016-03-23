package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author lichenjie0522
 *
 */
public class No040_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		List<Integer> comb = new ArrayList<Integer>();
		Arrays.sort(candidates);
		dfs(res, comb, candidates, target, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int pos) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(comb));
			return;
		}
		if (target < 0 || pos > candidates.length) {
			return;
		}
		for (int i = pos; i < candidates.length; ++i) {
			// 不能有重复的组合加入res中，所以对相同的元素要continue，否则会出现res中有如[1(第一个), 7]和[1(第二个), 7]的情况
			if (i > pos && candidates[i] == candidates[i - 1]) {
				continue;
			}
			comb.add(candidates[i]);
			dfs(res, comb, candidates, target - candidates[i], i + 1);
			comb.remove(comb.size() - 1);
		}
	}
}
