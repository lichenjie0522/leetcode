package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree, 1 <--- / \ 2 3 <--- \ \ 5 4
 * <--- You should return [1, 3, 4].
 * 
 * @author lichenjie0522
 *
 */
public class No199_BinaryTreeRightSideView {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 层次遍历，记录每一层最右边的值
	public List<Integer> rightSideView1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		List<TreeNode> current = new LinkedList<TreeNode>();
		List<TreeNode> next = new LinkedList<TreeNode>();
		current.add(root);
		while (!current.isEmpty()) {
			TreeNode node = current.remove(0);
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			if (current.isEmpty()) {
				res.add(node.val);
				current = next;
				next = new LinkedList<TreeNode>();
			}
		}
		return res;
	}
	
	//dfs, record the level
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		dfs(root, res, 0);
		return res;
	}
	
	private void dfs(TreeNode root, List<Integer> res, int level) {
	    if (root == null) {
	        return;
	    }
	    if (res.size() == level) {
	        res.add(root.val);
	    }
	    if (root.right != null) {
	        dfs(root.right, res, level + 1);
	    }
	    if (root.left != null) {
	        dfs(root.left, res, level + 1);
	    }
	}
}
