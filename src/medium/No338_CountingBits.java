package medium;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass? Space complexity should be O(n). Can you do it like a boss? Do
 * it without using any builtin function like __builtin_popcount in c++ or in
 * any other language. Hint:
 * 
 * You should make use of what you have produced already. Divide the numbers in
 * ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range
 * from previous. Or does the odd/even status of the number help you in
 * calculating the number of 1s?
 * 
 * @author lichenjie0522
 *
 */
public class No338_CountingBits {
	
	//3ms
	//利用上一组的结果推断出下一组的结果
	public int[] countBits1(int num) {
		int[] res = new int[num + 1];
		if (num < 0) {
			return res;
		}
		int pow = 1;
		int c = 0;
		res[0] = 0;
		for (int i = 1; i <= num; i++, c++) {
			if (i == pow) {
				pow *= 2;
				c = 0;
			}
			res[i] = res[c] + 1;
		}
		return res;
	}
	
	//4ms
	public int[] countBits(int num) {
        int[] res = new int[num+1];
        if (num < 0) {
            return res;
        }
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
