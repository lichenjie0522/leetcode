package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * @author lichenjie0522
 *
 */
public class No145_BinaryTreePostorderTraversal {
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
	public List<Integer> postorderTraversal_Recursive(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		postorder(res, root);
		return res;
	}

	private void postorder(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		postorder(res, root.left);
		postorder(res, root.right);
		res.add(root.val);
	}

	/**
	 * Iterative:
	 * 
	 * Time Complexity - O(n)，Space Complexity - O(n)。
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				res.add(0, node.val);
				stack.push(node.left);
				stack.push(node.right);
			}
		}
		return res;
	}
}
