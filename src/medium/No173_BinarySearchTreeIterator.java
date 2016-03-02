package medium;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * 完整的中序遍历会很慢
 * 
 * @author lichenjie0522
 *
 */
public class No173_BinarySearchTreeIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode node = null;
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public No173_BinarySearchTreeIterator(TreeNode root) {
        node = root;
    }

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !(node == null && stack.empty());
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		TreeNode res = null;
		if (node == null) {
			res = stack.pop();
			node = res.right;
		} else {
			while (node.left != null) {
				stack.push(node);
				node = node.left;
			}
			res = node;
			node = node.right;
		}
		return res.val;
	}
}
