package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author lichenjie0522
 *
 */
public class No118_PascalsTriangle {
	public List<List<Integer>> generate1(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows < 1) {
			return result;
		}
		List<Integer> level = new ArrayList<Integer>();
		level.add(1);
		result.add(level);
		for (int i = 1; i < numRows; ++i) {
			level = new ArrayList<Integer>();
			level.add(1);
			for (int j = 1; j < result.get(i - 1).size(); ++j) {
				level.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
			}
			level.add(1);
			result.add(level);
		}
		return result;
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++) {
            list.add(0, 1);
            
            for(int j = 1; j < list.size() - 1; j++)
                list.set(j, list.get(j) + list.get(j + 1));
            
            res.add(new ArrayList<Integer>(list));
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		System.err.println(new No118_PascalsTriangle().generate(5));
	}
}
