package easy;

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * 
 * @author lichenjie0522
 *
 */
public class No036_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return false;
		}
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] != '.' && !set.add(board[i][j])) {
					return false;
				}
			}
			set.clear();
		}
		for (int j = 0; j < 9; ++j) {
			for (int i = 0; i < 9; ++i) {
				if (board[i][j] != '.' && !set.add(board[i][j])) {
					return false;
				}
			}
			set.clear();
		}
		for (int i = 1; i < 9; i += 3) {
			for (int j = 1; j < 9; j += 3) {
				for (int k = -1; k <= 1; ++k) {
					for (int l = -1; l <= 1; ++l) {
						if (board[i+k][j+l] != '.' && !set.add(board[i+k][j+l])) {
							return false;
						}
					}
				}
				set.clear();
			}
		}
		return true;
	}
}
