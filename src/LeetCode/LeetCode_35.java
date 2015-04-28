package LeetCode;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * @author xujian
 * search insert position
 */
public class LeetCode_35 {
	
	public static int searchInsert(int[] A, int target){
		for(int i = 0; i< A.length; i++){
			if(A[i] >= target){
				return i;
			}
		}
		return A.length;
	}

	public static void main(String[] args) {
		int[] A = {1,3,5,6};
		int target = 0;
		System.out.println(searchInsert(A, target));
	}

}
