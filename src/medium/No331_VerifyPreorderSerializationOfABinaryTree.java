package medium;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we
 * encounter a non-null node, we record the node's value. If it is a null node,
 * we record using a sentinel value such as #.
 * 
 * Given a string of comma separated values, verify whether it is a correct
 * preorder traversal serialization of a binary tree. Find an algorithm without
 * reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a
 * character '#' representing null pointer.
 * 
 * You may assume that the input format is always valid, for example it could
 * never contain two consecutive commas such as "1,,3".
 * 
 * Example 1: "9,3,4,#,#,1,#,#,2,#,6,#,#" Return true
 * 
 * Example 2: "1,#" Return false
 * 
 * Example 3: "9,#,#,1" Return false
 * 
 * @author lichenjie0522
 *
 */
public class No331_VerifyPreorderSerializationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0) {
			return false;
		}
		String s = preorder;
		boolean flag = true;
		while (s.length() > 1) {
			int index = s.indexOf(",#,#");
			if (index < 0) {
				flag = false;
				break;
			}
			int start = index;
			while (start > 0 && s.charAt(start - 1) != ',') {
				start--;
			}
			if (s.charAt(start) == '#') {
				flag = false;
				break;
			}
			s = s.substring(0, start) + s.substring(index + 3);
		}
		if (s.equals("#") && flag) {
			return true;
		} else {
			return false;
		}
	}
}
