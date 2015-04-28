package LeetCode;
/**
 * 
 * @author xujian
 * Remove Element 
 */
public class LeetCode_27 {
	//Use 2 pointers for this one.
	//The first portion will be not equals
	public static int removeElement(int[] A, int elem){
		if (A.length == 0 || A == null) {
			return 0;
		}
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			while (start < A.length && A[start] != elem) {
				start++;
			}
			while (end >= 0 && A[end] == elem) {
				end--;
			}
			if (start <= end) {
				int temp = A[start];
				A[start] = A[end];
				A[end] = temp;
			}
		}
		return start;
	}
	
	public static int removeElement2(int[] A, int elem){
		 int length = A.length;
		 for(int i = 0; i < length; i++){
			 while(A[i] == elem && i < length){
				 A[i] = A[--length];
			 }
		 }
		 return length;
	}
}
