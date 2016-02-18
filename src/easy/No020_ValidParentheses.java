package easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author lichenjie0522
 *
 */
public class No020_ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); ++i) {
			char left = s.charAt(i);
			if ( left == '(' || left == '[' || left == '{') {
				stack.push(left);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char right = stack.pop();
				if (left == ')' && right != '(' || left == ']' && right != '[' || left == '}' && right != '{') {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
