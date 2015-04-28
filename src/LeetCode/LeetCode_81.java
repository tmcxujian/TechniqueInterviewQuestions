package LeetCode;
/**
 * With duplicates. Write a function to determine if a given target is in the array.
 * @author xujian
 * Search in Rotated Sorted Array II 
 */
public class LeetCode_81 {

	public static boolean search(int[] A, int target) {
		int L = 0;
		int R = A.length - 1;
		//first step to find minimun number in the array
		//below is actually how we use to find the minimum number in rotated array
		while(L < R){
			int M = (L + R) / 2;
			if(A[M] > A[R]){
				L = M + 1;
			}
			else if (A[M] < A[R]){
				R = M;
			}
			else{
				L = L + 1;
			}
		}
		int offset = L;
		L = 0;
		R = A.length - 1;
		while(L <= R){
			int M = (L+R) / 2;
			int realMid = (M + offset) % A.length;
			if(A[realMid] == target){
				return true;
			}
			else if(A[realMid] > target){
				R = M - 1;
			}
			else{
				L = M + 1;
			}
		}
        return false;
    }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2,3};
		int[] B = {3,1,1,1,1};
		int[] C = {1};
		System.out.println(search(A,8));
		System.out.println(search(B,3));
		System.out.println(search(C,1));
	}

}
