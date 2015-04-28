package LeetCode;

/**
 * Set matrix to be 0
 * @author xujian
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 * similar as CC Chapter1_7
 */
public class LeetCode_73 {
	
	public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
        		return;
        }
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
        		for(int j = 0; j < matrix[0].length; j++){
        			if(matrix[i][j] == 0){
        				row[i] = 1;
        				col[j] = 1;
        			}
        		}
        }
        for(int i = 0; i < matrix.length; i++){
    			for(int j = 0; j < matrix[0].length; j++){
    				if(row[i] == 1 || col[j] == 1){
    					matrix[i][j] = 0;
    				}
    			}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,1},{1,1,1},{1,1,1}};
		setZeroes(matrix);
		for(int i = 0; i < matrix.length; i++){
    			for(int j = 0; j < matrix[0].length; j++){
    				System.out.println(matrix[i][j]);
    			}
		}
	}

}
