package medium;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author lichenjie0522
 *
 */
public class No105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi) {
		if (preLo > preHi || inLo > inHi) {
			return null;
		}
		int rootVal = preorder[preLo];
		TreeNode root = new TreeNode(rootVal);
		int rootIndexAtInorder = inLo;
		while (rootIndexAtInorder <= inHi) {
			if (inorder[rootIndexAtInorder] == rootVal) {
				break;
			}
			rootIndexAtInorder++;
		}
		int leftTreeLen = rootIndexAtInorder - inLo;
		root.left = buildTree(preorder, preLo + 1, preLo + leftTreeLen, inorder, inLo, rootIndexAtInorder - 1);
		root.right = buildTree(preorder, preLo + leftTreeLen + 1, preHi, inorder, rootIndexAtInorder + 1, inHi);
		return root;
	}
}
