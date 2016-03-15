package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] Note: For the return value,
 * each inner list's elements must follow the lexicographic order. All inputs
 * will be in lower-case.
 * 
 * @author lichenjie0522
 *
 */
public class No049_GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; ++i) {
        	List<String> list = new ArrayList<String>();
        	char[] carr = strs[i].toCharArray();
        	Arrays.sort(carr);
        	String s = String.valueOf(carr);
        	if (map.containsKey(s)) {
        		list = map.get(s);
        	}
        	list.add(strs[i]);
    		map.put(s, list);
        }
        for (List<String> list : map.values()) {
        	Collections.sort(list);
        	res.add(list);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		for (List<String> list : res) {
			System.out.println(list);
		}
	}
}
