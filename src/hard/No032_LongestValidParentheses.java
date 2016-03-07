package hard;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * 维护一个stack以及一个start index，遇到左括号入栈，遇到右括号出栈，当stack为空时说明左右括号平衡，计算i 与 start的距离，
 * 否则左括号数目>右括号数目，计算i 与当前栈顶元素距离。
 * 
 * @author lichenjie0522
 *
 */
public class No032_LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int start = 0;
		for (int i = 0; i < s.length(); ++i) {
			Character ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				if (stack.empty()) {
					start = i + 1;
				} else {
					stack.pop();
					if (stack.empty()) {
						max = Math.max(max, i - start + 1);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new No032_LongestValidParentheses().longestValidParentheses("((())())"));
	}
}
