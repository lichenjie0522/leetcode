package easy;

/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1: Given s = "hello", return "holle".
 * 
 * Example 2: Given s = "leetcode", return "leotcede".
 * 
 * @author lichenjie0522
 *
 */
public class No345_ReverseVowelsOfAString {
	public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int i = 0, j = s.length() - 1;
        char[] carr = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowels(s.charAt(i))) {
                i++;
            }
            while (i < j && !isVowels(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                char tmp = carr[i];
                carr[i] = carr[j];
                carr[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(carr);
    }

	private boolean isVowels(char c) {
		char v = Character.toLowerCase(c);
		return v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u';
	}
	
	public static void main(String[] args) {
		System.out.println(new No345_ReverseVowelsOfAString().reverseVowels(".,"));
	}
}
