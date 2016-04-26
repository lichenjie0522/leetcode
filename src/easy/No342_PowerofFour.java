package easy;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example: Given num = 16, return true. Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * @author lichenjie0522
 *
 */
public class No342_PowerofFour {
	public boolean isPowerOfFour(int num) {
		double res = Math.log(num) / Math.log(4);
		return Math.abs(res - Math.round(res)) < 10e-15;
	}
}
