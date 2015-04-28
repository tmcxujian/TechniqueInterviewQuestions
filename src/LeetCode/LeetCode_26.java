package LeetCode;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * @author xujian
 * Given a sorted array, remove the duplicates in place such that each 
 * element appear only once and return the new length.
 * Do not allocate extra space for another array, 
 * you must do this in place with constant memory.
 * For example,Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */

public class LeetCode_26 {
	public static int removeDuplicates(int[] A){
		if(A.length == 0){
			return 0;
		}
		int j = 0;
		for(int i = 1; i < A.length; i++){
			if(A[i] != A[j]){
				A[++j] = A[i];
			}
			else{
				continue;
			}
		}
		A = Arrays.copyOf(A, j+1);
		return j+1;
	}
}
