package hard;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * 
 * For example: Given the below binary tree, 1 / \ 2 3 Return 6.
 * 
 * 树结构显然用递归来解，解题关键：o(n)
 * 
 * 1、对于每一层递归，只有包含此层树根节点的值才可以返回到上层。否则路径将不连续。
 * 
 * 2、返回的值最多为根节点加上左右子树中的一个返回值，而不能加上两个返回值。否则路径将分叉。
 * 
 * 在这两个前提下有个需要注意的问题，最上层返回的值并不一定是满足要求的最大值，
 * 
 * 因为最大值对应的路径不一定包含root的值，可能存在于某个子树上。
 * 
 * 因此解决方案为设置全局变量maxSum，在递归过程中不断更新最大值。
 * 
 * @author lichenjie0522
 *
 */
public class No124_BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		getMax(root);
		return max;
	}

	private int getMax(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int maxLeft = getMax(root.left);
		int maxRight = getMax(root.right);
		int maxRoot = root.val;
		if (maxLeft >= maxRight && maxLeft > 0) {
			maxRoot += maxLeft;
		} else if (maxRight > 0) {
			maxRoot += maxRight;
		}
		max = maxRoot > max ? maxRoot : max;
		if (maxLeft > 0 && maxRight > 0) {
			int tmp = maxLeft + maxRight + root.val;
			max = max > tmp ? max : tmp;
		}
		return maxRoot;
	}
}
