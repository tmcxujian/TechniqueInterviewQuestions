package LeetCode;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * @author xujian
 * First mising positive
 */

public class LeetCode_41 {

	public static int firstMissingPositive(int[] A){
		if(A.length == 0){
			return 1;
		}
		Arrays.sort(A);
		int count = 1;
		int prev = 0;
		int i = 0;
		//除去所有的小于等于0的数字
		while(A[i] <= 0 && i < A.length - 1){
			i++;
		}
		//遍历,prev是为了防止重复数字的作用
		for(;i < A.length; i++){
			if(A[i] == count){
				count++;
				prev ++;
			}
			else if(A[i] == prev){
				continue;
			}
			else{
				return count;
			}
		}
		return A[A.length-1] + 1;
	}
	
	//Goal: each positive integer p should be placed at index p-1; 
	//in the end, iterate from index=0 to right, 
	//stop at the first index whose value is non-positive; 
	//and return the missing integer as index+1.
	public static int firstMissingPositive2(int[] A){
		for(int i = 0; i < A.length; i++){
			int num = A[i];
			//里面这个条件很有意思，完全表达就是
			//A[A[i] - 1] != A[i],去掉A[],就是A[i]-1 != i
			while(num > 0 && num <= A.length && A[num - 1] != num){
				//swap A[i] && A[A[i]-1]
				int temp = A[num - 1];
				A[num-1] = num;
				num = temp;
			}
		}
		for(int i = 0; i < A.length; i++){
			if(A[i] != i + 1){
				return i+1;
			}
		}
		return A.length+1;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,1,2,2};
		int[] B = {3,4,-1,1};
		int[] C = {2,1};
		System.out.println(firstMissingPositive(A));
		System.out.println(firstMissingPositive(B));
		System.out.println(firstMissingPositive(C));
	}

}
