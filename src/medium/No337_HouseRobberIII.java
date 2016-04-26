package medium;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * @author lichenjie0522
 *
 */

public class No337_HouseRobberIII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = dp(root);
		return Math.max(max[0], max[1]);
	}

	private int[] dp(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}
		// max[0] store the max value without robing current node, max[1] store
		// the max value with robing current node
		int[] max = new int[2];
		int[] leftMax = dp(root.left);
		int[] rightMax = dp(root.right);
		max[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
		max[1] = root.val + leftMax[0] + rightMax[0];
		return max;
	}
}
