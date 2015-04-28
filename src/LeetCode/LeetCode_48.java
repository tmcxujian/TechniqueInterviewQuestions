package LeetCode;


/**
 * 
 * @author xujian
 * rotate image
 */
public class LeetCode_48 {
	
	//first one is using common way -- symmetric way
	//因为对称，所以凡事只要一般就可以了
	//规律就是保持前面的i坐标不变，变成后面的j坐标
	//前面的j坐标与后面i左边相加 = n
	public static void rotate(int[][] matrix){
		int n = matrix.length - 1;
		for(int i = 0; i <= n - i; i++){
			for(int j = i; j <= n - i - 1; j++){
				int tmp = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = tmp;
			}
		}
	}
}
