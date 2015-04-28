package LeetCode;
/**
 * 地图搜索差不多
 * @author xujian
 * Word Search
 */

public class LeetCode_79 {

	public static boolean exist(char[][] board,String word){
		boolean result = false;
		boolean[][] used = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == word.charAt(0)){
					result = searchNext(board,used,0,word,i,j);
					if(result){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean searchNext(char[][] board, boolean[][] used, int charAt,
			String word, int i, int j){
		if(charAt == word.length()){
			return true;
		}
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
			return false;
		}
		if(!used[i][j] && board[i][j] == word.charAt(charAt)){
			used[i][j] = true;
			//left -> right -> down -> top
			if(searchNext(board, used, charAt+1, word, i, j-1)){
				return true;
			}
			if(searchNext(board, used, charAt+1, word, i, j+1)){
				return true;
			}
			if(searchNext(board, used, charAt+1, word, i-1, j)){
				return true;
			}
			if(searchNext(board, used, charAt+1, word, i+1, j)){
				return true;
			}
			used[i][j] = false;
		}		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
