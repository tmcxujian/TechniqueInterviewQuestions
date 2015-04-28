package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * @author xujian
 * single number
 */
public class LeetCode_136 {

	//usign bit manipulation
	public static int singleNumber(int[] A){
		int result = 0;
		for(int i = 0; i < A.length; i++){
			result ^= A[i];
		}
		return result;
	}
	
	//using hash tables
	public static int singleNumber2(int[] A){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < A.length; i++){
			if(set.contains(A[i])){
				set.remove(A[i]);
			}
			else{
				set.add(A[i]);
			}
		}
		return set.iterator().next();
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,2,3,3,4,4};
		System.out.println(singleNumber(A));
	}

}
