package easy;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * @author lichenjie0522
 *
 */
public class No326_PowerOfThree {
	public boolean isPowerOfThree(int n) {
		double res = Math.log(n) / Math.log(3);
		return Math.abs(res - Math.round(res)) < 10e-15;
	}
}
