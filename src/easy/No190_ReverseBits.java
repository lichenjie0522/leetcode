package easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * @author lichenjie0522
 *
 */
public class No190_ReverseBits {
	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		n = ((n >> 1) & 0x55555555) | ((n << 1) & 0xAAAAAAAA);
		n = ((n >> 2) & 0x33333333) | ((n << 2) & 0xCCCCCCCC);
		n = ((n >> 4) & 0x0F0F0F0F) | ((n << 4) & 0xF0F0F0F0);
		n = ((n >> 8) & 0x00FF00FF) | ((n << 8) & 0xFF00FF00);
		n = ((n >> 16) & 0x0000FFFF) | ((n << 16) & 0xFFFF0000);
		return n;
	}
}
