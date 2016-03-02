package medium;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author lichenjie0522
 *
 */
public class No064_MinimumPathSum {
	// 只能走右边或者下面，因此DP时选择应为左或者上，对第一行和第一列做预处理
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int rowNum = grid.length;
		int colNum = grid[0].length;
		for (int i = 1; i < rowNum; ++i) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int j = 1; j < colNum; ++j) {
			grid[0][j] += grid[0][j - 1];
		}
		for (int i = 1; i < rowNum; ++i) {
			for (int j = 1; j < colNum; ++j) {
				grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
			}
		}
		return grid[rowNum - 1][colNum - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 2 }, { 1, 1 } };
		System.out.println(new No064_MinimumPathSum().minPathSum(grid));
	}
}
