package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * @author lichenjie0522
 *
 */
public class No144_BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Recursive:
	 * 
	 * Time Complexity - O(n)， Space Complexity - O(n)。
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal_recursive(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		preorder(res, root);
		return res;
	}

	private void preorder(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		preorder(res, root.left);
		preorder(res, root.right);
	}

	/**
	 * Iterative:
	 * 
	 * Time Complexity - O(n)， Space Complexity - O(n)。
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.empty()) {
			if (root != null) {
				stack.push(root);
				res.add(root.val);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
		return res;
	}
}
