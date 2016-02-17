package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author lichenjie0522
 *
 */
public class No228_SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		if (nums == null || nums.length < 1) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		int start = 0;
		int end = 0;
		while (end < nums.length) {
			if (end +1 < nums.length && nums[end] + 1 == nums[end + 1]) {
				end++;
			} else {
				if (start == end){
					result.add(String.valueOf(start));
				} else {
					result.add(String.valueOf(start) + "->" + String.valueOf(end));
				}
				start = ++end;
			}
		}
		return result;
	}
}
