package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * @author xujian
 *
 */
public class LeetCode_54 {

	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		int n = 0;
		if(m != 0){
			n = matrix[0].length;
		}
		int cycle = m > n ? (n + 1) / 2 : (m + 1) / 2;
		int a = n;
		int b = m;
		for(int i = 0; i < cycle; i++, a -= 2, b -= 2){
			//每个环的左上角起点是matrix[i][i],下面顺时针依次打印环的四条边
            for(int column = i; column < i+a; column++){
            	 	list.add(matrix[i][column]);
            }
			for (int row = i + 1; row < i + b; row++)
				list.add(matrix[row][i + a - 1]);
			if (a == 1 || b == 1)
				break; // 最后一个环只有一行或者一列
			for (int column = i + a - 2; column >= i; column--)
				list.add(matrix[i + b - 1][column]);
			for (int row = i + b - 2; row > i; row--)
				list.add(matrix[row][i]);
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
