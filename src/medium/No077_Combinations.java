package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * 使用DFS + Backtracking
 * 
 * @author lichenjie0522
 *
 */
public class No077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combine(result, list, n, k, 1);
		return result;
	}

	private void combine(List<List<Integer>> result, List<Integer> list, int n, int k, int pos) {
		if (list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = pos; i <= n; ++i) {
			list.add(i);
			combine(result, list, n, k, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new No077_Combinations().combine(4, 2));
	}
}
