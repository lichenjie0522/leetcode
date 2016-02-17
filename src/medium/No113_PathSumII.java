package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author lichenjie0522
 *
 */
public class No113_PathSumII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		pathSumRecur(root, sum, result, path);
		return result;
	}

	private static void pathSumRecur(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList<Integer>(path));
		}
		pathSumRecur(root.left, sum - root.val, result, path);
		pathSumRecur(root.right, sum - root.val, result, path);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(8);
		TreeNode t3 = new TreeNode(11);
		TreeNode t4 = new TreeNode(13);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(2);
		TreeNode t8 = new TreeNode(5);
		TreeNode t9 = new TreeNode(1);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t5.left = t8;
		t5.right = t9;
		List<List<Integer>> result = pathSum(root, 22);
		for (List<Integer> re : result) {
			System.err.println(re);
		}
	}
}
