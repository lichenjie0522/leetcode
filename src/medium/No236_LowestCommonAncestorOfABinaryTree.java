package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * @author lichenjie0522
 *
 */
public class No236_LowestCommonAncestorOfABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		List<TreeNode> pathP = new ArrayList<TreeNode>();
		List<TreeNode> pathQ = new ArrayList<TreeNode>();
		pathP.add(root);
		pathQ.add(root);
		getPath(root, p, pathP);
		getPath(root, q, pathQ);
		
		TreeNode result = null;
		for (int i = 0; i < pathP.size() && i < pathQ.size(); ++i) {
			if (pathP.get(i).equals(pathQ.get(i))) {
				return pathP.get(i);
			}
		}
		return result;
	}

	private boolean getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
		if (root.equals(node)) {
			return true;
		}
		if (root.left != null) {
			path.add(root.left);
			if (getPath(root.left, node, path)) {
				return true;
			}
			path.remove(path.size() - 1);
		}
		if (root.right != null) {
			path.add(root.right);
			if (getPath(root.right, node, path)) {
				return true;
			}
			path.remove(path.size() - 1);
		}
		return false;
	}
}
