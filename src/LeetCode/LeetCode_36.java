package LeetCode;

import java.util.Arrays;

/**
 * Valid Sudoku
 * @author xujian
 *
 */
public class LeetCode_36 {
	
	public static boolean isValidSudoku(char[][] board){
		int[] rowValid = new int[10];
		int[][] columnValid = new int[9][10];
		int[][] subBoardValid = new int[9][10];
		for(int i = 0; i < 9; i++){
			Arrays.fill(rowValid, 0);
			for(int j = 0; j < 9; j++){
				if(board[i][j] != '.'){
					if(!checkValid(rowValid, board[i][j] - '0') ||
							!checkValid(columnValid[j], board[i][j] - '0') ||
							!checkValid(subBoardValid[i/3*3+j/3], board[i][j] - '0')){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static boolean checkValid(int[] vector, int x){
		if(vector[x] == 1){
			return false;
		}
		vector[x] = 1;
		return true;
	}
}
