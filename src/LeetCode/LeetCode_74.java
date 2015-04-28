package LeetCode;
/**
 * Search in a 2D Matrix
 * @author xujian
 *
 */
public class LeetCode_74 {

	public static boolean searchMatrix(int[][] matrix, int target){
		int a = matrix.length;
		if(a == 0){
			return false;
		}
		int b = matrix[0].length;
		int total = a * b;
		a = 0;
		b = total - 1;
		return search(matrix, a, b, target);
	}
	
	public static boolean search(int[][] matrix, int start, int end, int target){
		while(start <= (end)){
			int mid = (start + end) / 2;
			int yValue = mid / matrix[0].length;
			int xValue = mid - yValue * matrix[0].length;
			if(matrix[yValue][xValue] > target){
				end = mid - 1;
			}
			else if(matrix[yValue][xValue] < target){
				start = mid + 1;
			}
			else{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(m, 4));
		System.out.println(searchMatrix(m, 3));
		System.out.println(searchMatrix(m, 1));
		System.out.println(searchMatrix(m, 50));
	}

}
