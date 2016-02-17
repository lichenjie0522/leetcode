package easy;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author lichenjie0522
 *
 */
public class No110_BalancedBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int l = height(root.left);
		int r = height(root.right);
		if (l < 0 || r < 0 || Math.abs(l - r) > 1) {
			return false;
		}
		return true;
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = height(root.left);
		int r = height(root.right);
		if (l < 0 || r < 0 || Math.abs(l - r) > 1) {
			return -1;
		}
		return l < r ? r + 1 : l + 1;
	}

}
