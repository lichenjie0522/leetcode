package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author lichenjie0522
 *
 */
public class No107_BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> nodeValues = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		List<TreeNode> current = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();
		current.add(root);
		while (!current.isEmpty()) {
			TreeNode node = current.remove(0);
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			nodeValues.add(node.val);
			if (current.isEmpty()) {
				current = next;
				next = new ArrayList<TreeNode>();
				result.add(nodeValues);
				nodeValues = new ArrayList<Integer>();
			}
		}
		reverseList(result);
		return result;
	}

	private void reverseList(List<List<Integer>> result) {
		if (result == null || result.size() <= 1) {
			return;
		}
		int i = 0;
		int j = result.size() - 1;
		while (i < j) {
			List<Integer> tmp = result.get(i);
			result.set(i, result.get(j));
			result.set(j, tmp);
			i++;
			j--;
		}
	}
}
