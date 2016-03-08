package medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * @author lichenjie0522
 *
 */
public class No074_Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		int lo = 0, hi = rowNum * colNum - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int row = mid / colNum;
			int col = mid % colNum;
			if (matrix[row][col] < target) {
				lo = mid + 1;
			} else if (matrix[row][col] > target) {
				hi = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
