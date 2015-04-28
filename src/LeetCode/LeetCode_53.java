package LeetCode;

import java.util.Arrays;

/**
 * Find the "contiguous" (very important) subarray within an array (containing at least one number) 
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author xujian
 * Max subarray sum
 */
public class LeetCode_53 {
	//this is Dynamic Programming
	//f(k) = max( f(k-1) + A[k], A[k] )
	public static int maxSubArray(int[] A){
		if(A == null || A.length == 0){
			return A[0];
		}
		int sum = A[0];
		int maxSoFar = A[0];
	    for(int i = 1; i < A.length; i++){
	    		maxSoFar = (maxSoFar + A[i] > A[i]) ? maxSoFar + A[i] : A[i];
	    		sum = sum > maxSoFar ? sum : maxSoFar;
	    }
		return sum;
	}
	
	//This second one is divide and conquer
	public static int maxSubArray2(int[] A){
		if(A == null || A.length == 0){
			return A[0];
		}
		return maxSubArrayHelper(A,0,A.length-1);
	}
	
	//三种情况对于这个最大subarray sum
	//1， left + Mid + right
	//2， left
	//3， right
	public static int maxSubArrayHelper(int[] A, int L, int R){
		if(L > R){
			return Integer.MIN_VALUE;
		}
		int M = (L + R) / 2;
		int leftAns = maxSubArrayHelper(A, L, M-1);
		int rightAns = maxSubArrayHelper(A, M+1, R);
		int lMaxSum = 0;
		int rMaxSum = 0;
		int sum = 0;
		for(int i = M - 1; i >= L; i--){
			sum += A[i];
			lMaxSum = Math.max(lMaxSum,sum);
		}
		sum = 0;
		for(int i = M+1; i <= R; i++){
			sum += A[i];
			rMaxSum = Math.max(rMaxSum,sum);
		}
		sum = Math.max(lMaxSum + A[M] + rMaxSum, Math.max(leftAns,rightAns));
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,-1,1};
		System.out.println(maxSubArray2(A));
	}

}
