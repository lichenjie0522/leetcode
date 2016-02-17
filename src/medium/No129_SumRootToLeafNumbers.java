package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author lichenjie0522
 *
 */
public class No129_SumRootToLeafNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<String> results = new ArrayList<String>();
	
	public int sumNumbers(TreeNode root) {
		if (root != null) {
			getPaths(root, String.valueOf(root.val));
		}
		int sum = 0;
		for (String num : results) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}

	private void getPaths(TreeNode node, String valPath) {
		if (node.left == null && node.right == null) {
			results.add(valPath);
		}
		if (node.left != null) {
			getPaths(node.left, valPath + node.left.val);
		}
		if (node.right != null) {
			getPaths(node.right, valPath + node.right.val);
		}
	}
}
