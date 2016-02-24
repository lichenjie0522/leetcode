package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author lichenjie0522
 *
 */
public class No094_BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//Iterative: Time Complexity - O(n)， Space Complexity - O(n) (worst case)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}
	
	//Recursive: Time Complexity - O(n)， Space Complexity - O(n) (worst case)
	public List<Integer> inorderTraversal_Recursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Inorder(root, result);
		return result;
	}

	private void Inorder(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		Inorder(root.left, result);
		result.add(root.val);
		Inorder(root.right, result);
	}
}
