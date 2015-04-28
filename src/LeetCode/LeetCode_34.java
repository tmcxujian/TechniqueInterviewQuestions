package LeetCode;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchResult;

/**
 * Given a sorted array of integers, 
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * @author xujian
 * Search for a range
 */
public class LeetCode_34 {

	public static int[] searchRange(int[] A, int target){
		int[] defaultResult = {-1,-1};
		int i = 0;
		int j = A.length - 1;
		while(i <= j){
			int mid = (i+j)/2;
			if(A[mid] == target){
				int[] result = new int[2];
				int index = mid;
				while(index >= 0 && A[index] == target){
					index--;
				}				
				result[0] = index+1;
				while(mid <= A.length - 1 && A[mid] == target){
					mid++;
				}
				result[1] = mid - 1;
				return result;
			}
			else if(A[mid] < target){
				i = mid + 1;
			}
			else{
				j = mid - 1;
			}
		}
		return defaultResult;
	}
	
	public static void main(String[] args) {
		int[] A = {5,7,7,8,8,10};
		int[] C = {8,8};
		int[] B = searchRange(C,8);
		for(int i : B){
			System.out.println(i);
		}
	}

}
