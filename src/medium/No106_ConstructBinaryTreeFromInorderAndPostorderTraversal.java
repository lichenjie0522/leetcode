package medium;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author lichenjie0522
 *
 */
public class No106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
			return null;
		}
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTree(int[] inorder, int inLo, int inHi, int[] postorder, int postLo, int postHi) {
		if (inLo > inHi || postLo > postHi) {
			return null;
		}
		int rootVal = postorder[postHi];
		TreeNode root = new TreeNode(rootVal);
		int rootIndexAtInorder = inLo;
		while (rootIndexAtInorder <= inHi) {
			if (inorder[rootIndexAtInorder] == rootVal) {
				break;
			}
			rootIndexAtInorder++;
		}
		int leftTreeLen = rootIndexAtInorder - inLo;
		root.left = buildTree(inorder, inLo, rootIndexAtInorder - 1, postorder, postLo, postLo + leftTreeLen - 1);
		root.right = buildTree(inorder, rootIndexAtInorder + 1, inHi, postorder, postLo + leftTreeLen, postHi - 1);
		return root;
	}
}
