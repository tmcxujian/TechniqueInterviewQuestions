package LeetCode;

/**
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target
 * value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @author xujian search in rotated array
 */
public class LeetCode_33 {

	public static int search(int[] A, int target) {
		int L = 0;
		int R = A.length - 1;
		//first step to find minimun number in the array
		//below is actually how we use to find the minimum number in rotated array
		while(L < R){
			int M = (L + R) / 2;
			if(A[M] > A[R]){
				L = M + 1;
			}
			else{
				R = M;
			}
		}
		int offset = L;
		L = 0;
		R = A.length - 1;
		while(L <= R){
			int M = (L+R) / 2;
			int realMid = (M + offset) % A.length;
			if(A[realMid] == target){
				return realMid;
			}
			else if(A[realMid] > target){
				R = M - 1;
			}
			else{
				L = M + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] A = {4,5,6,7,0,1,2,3};
		int[] B = {3,1};
		int[] C = {1};
		System.out.println(search(A, 8));
		System.out.println(search(B, 1));
		System.out.println(search(C, 0));
	}
}
