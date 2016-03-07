package hard;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * For example, Given heights = [2,1,5,6,2,3], return 10.
 * 
 * 维护一个递增栈（或者一个Deque），
 * 当栈为空或者当前元素比栈顶元素大时，把当前元素入栈。否则把栈顶元素出栈，继续比较下一个栈顶元素与当前元素的大小。假如是1,2,3,4,1的话，
 * 运行到第2个1的时候，就要先出栈4，计算4 x 1，再是 3 x 2， 2 x 3，之后1 入栈， 最后!stack.isEmpty()计算 1 x 4。
 * 也要注意边界条件 - pop到最后时假如stack.isEmpty(), 则h[tmp] * i。
 * 
 * @author lichenjie0522
 *
 */
public class No084_LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, max = 0;
		while (i < heights.length) {
			if (stack.empty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i++);
			} else {
				int tmp = stack.pop();
				max = Math.max(max, heights[tmp] * (stack.empty() ? i : (i - 1 - stack.peek())));
			}
		}
		while (!stack.empty()) {
			int tmp = stack.pop();
			max = Math.max(max, heights[tmp] * (stack.empty() ? i : (i - 1 - stack.peek())));
		}
		return max;
	}
}
