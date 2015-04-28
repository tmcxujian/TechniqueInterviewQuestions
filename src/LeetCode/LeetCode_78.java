package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets. Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * @author xujian
 * Subsets 
 */

public class LeetCode_78 {
	
	public static List<List<Integer>> subsets(int[] S) {		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(S.length == 0){
			return results;
		}
		Arrays.sort(S);
		List<Integer> single = new ArrayList<Integer>();
		single.add(S[0]);
		results.add(single);
		for(int i = 1; i < S.length;i++){
			results = calculateSubsets(results, S[i]);
		}
		List<Integer> empty = new ArrayList<Integer>();
		results.add(empty);
		return results;
    }
	
	public static List<List<Integer>> calculateSubsets(List<List<Integer>> results, int target){
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		for(int i = 0; i < results.size(); i++){
			List<Integer> t = new ArrayList<Integer>(results.get(i));
			t.add(target);
			temp.add(t);
		}
		results.addAll(temp);
		List<Integer> single = new ArrayList<Integer>();
		single.add(target);
		results.add(single);
		return results;
	}
	
	public static void main(String[] args){
		int[] S = {1,2,3};
		System.out.println(subsets(S));
	}
}
