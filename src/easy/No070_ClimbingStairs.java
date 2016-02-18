package easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author lichenjie0522
 *
 */
public class No070_ClimbingStairs {
	public int climbStairs1(int n) {
		if (n < 0) {
			return 0;
		}
		if (n <= 2) {
			return n;
		}
		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i < n + 1; ++i) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n];
	}

	public int climbStairs(int n) {
		if (n < 0) {
			return 0;
		}
		if (n <= 2) {
			return n;
		}
		int result = 0, prevStep = 1, curStep = 1;
		for (int i = 2; i < n + 1; ++i) {
			result = prevStep + curStep;
			prevStep = curStep;
			curStep = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.err.println(new No070_ClimbingStairs().climbStairs(3));
	}
}
