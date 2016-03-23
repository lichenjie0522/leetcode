package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * 
 * Example 1 Input: "2-1-1".
 * 
 * ((2-1)-1) = 0 (2-(1-1)) = 2 Output: [0, 2]
 * 
 * Example 2 Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10 (2*((3-4)*5)) =
 * -10 (((2*3)-4)*5) = 10 Output: [-34, -14, -10, -10, 10]
 * 
 * @author lichenjie0522
 *
 */
public class No241_DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();
		if (input == null || input.length() == 0) {
			return res;
		}
		for (int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> l1 = diffWaysToCompute(input.substring(0, i));
				List<Integer> l2 = diffWaysToCompute(input.substring(i + 1));
				for (int n1 : l1) {
					for (int n2 : l2) {
						if (c == '+') {
							res.add(n1 + n2);
						} else if (c == '-') {
							res.add(n1 - n2);
						} else {
							res.add(n1 * n2);
						}
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}
}
