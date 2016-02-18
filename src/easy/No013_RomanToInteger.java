package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author lichenjie0522
 *
 */
public class No013_RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, prev = map.get(s.charAt(s.length() - 1));
        result += prev;
        for (int i = s.length() - 2; i >= 0; --i) {
        	int cur = map.get(s.charAt(i));
        	if (cur < prev) {
        		result -= cur;
        	} else {
        		result += cur;
        		prev = cur;
        	}
        }
		return result;
	}
}
