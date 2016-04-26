package easy;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 * @author lichenjie0522
 *
 */
public class No344_ReverseString {
	public String reverseString(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int i = 0, j = s.length() - 1;
		char[] carr = s.toCharArray();
		while (i < j) {
			char c = carr[i];
			carr[i] = carr[j];
			carr[j] = c;
			i++;
			j--;
		}
		return new String(carr);
	}
	
	public static void main(String[] args) {
		System.out.println(new No344_ReverseString().reverseString("hello"));
	}
}
