package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * @author lichenjie0522
 *
 */
public class No257_BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	List<String> result = new ArrayList<String>();
	
	public List<String> binaryTreePaths(TreeNode root) {
		if (root != null) {
			getPath(root, String.valueOf(root.val));
		}
		return result;
    }

	private void getPath(TreeNode node, String path) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			result.add(path);
		}
		if (node.left != null) {
			getPath(node.left, path + "->" + node.left.val);
		}
		if (node.right != null) {
			getPath(node.right, path + "->" + node.right.val);
		}
	}
	
}
