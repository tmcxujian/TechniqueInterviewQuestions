package LeetCode;

/**
 * What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * @author xujian
 * Remove duplicates from sorted array II
 * last one is leetcode_26
 */
public class LeetCode_80 {
	//Here if we change itor and len to K. we could deal with other numbers as well.
	public static int removeDuplicates(int[] A){
		if(A.length < 2){
			return A.length;
		}
		int len = 2;
		int itor = 2;
		while(itor < A.length){
			if(A[itor] != A[len-2]){
				A[len++] = A[itor];
			}
			itor++;
		}
		return len;
	}
	
	public int removeDuplicates2(int[] A) {
		if (A.length <= 2)
			return A.length;
		int prev = 1; // point to previous
		int curr = 2; // point to current
		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
				curr++;
			} else {
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		} 
		return prev + 1;
	}
}
