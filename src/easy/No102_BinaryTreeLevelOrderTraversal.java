package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * @author lichenjie0522
 *
 */
public class No102_BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
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
				result.add(nodeValues);
				next = new ArrayList<TreeNode>();
				nodeValues = new ArrayList<Integer>();
			}
		}
		return result;
    }
	
}
