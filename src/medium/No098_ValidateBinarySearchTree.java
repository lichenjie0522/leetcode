package medium;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * 使用中序遍历，BST的中序遍历是递增的结果
 * 
 * @author lichenjie0522
 *
 */
public class No098_ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode previousNode = null;
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (previousNode != null && previousNode.val >= root.val) {
			return false;
		}
		previousNode = root;
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}
}
