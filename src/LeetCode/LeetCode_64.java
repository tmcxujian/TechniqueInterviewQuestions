package LeetCode;
/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * @author xujian
 * Minimum Path Sum
 */
public class LeetCode_64 {

	//DP and extra space.
	//if we can go left and up, then we should probably need Dijkstra
	public static int minimumPathSum(int[][] grid){
		if(grid == null){
			return 0;
		}
		int x = grid.length;
		int y = grid[0].length;
		int[][] result = new int[x][y];		
		for(int i = x-1; i >= 0; i--){
			for(int j = y-1; j >= 0; j--){
				if(i == (x-1) && j == (y-1)){
					result[x-1][y-1] = grid[x-1][y-1];
				}
				else if(i == (x-1) && j != (y-1)){
					result[i][j] = grid[i][j] + result[i][j+1];
				}
				else if(i != (x-1) && j == (y-1)){
					result[i][j] = grid[i][j] + result[i+1][j];
				}
				else{
					int sumOne = grid[i][j] + result[i][j+1];//right
					int sumTwo = grid[i][j] + result[i+1][j];//down
					result[i][j] = sumOne > sumTwo ? sumTwo : sumOne;
				}
			}
		}
		return result[0][0];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{3,6,9},{2,7,4},{8,1,5}};
		System.out.println(minimumPathSum(grid));
	}
	
}
