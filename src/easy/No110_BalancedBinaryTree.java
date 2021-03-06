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
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if (Math.abs(left - right) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getDepth(node.left), getDepth(node.right));
	}

}
