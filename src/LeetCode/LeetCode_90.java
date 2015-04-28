package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author xujian
 * SubSets with duplicates
 */
public class LeetCode_90 {

	private static Set<List<Integer>> set = new HashSet<List<Integer>>();
	//基于上一道subset的题目基础上，增加了一个HashSet来排除duplicate的可能性 
	public static List<List<Integer>> subsetsWithDup(int[] num){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(num.length == 0){
			return results;
		}
		Arrays.sort(num);
		List<Integer> single = new ArrayList<Integer>();
		single.add(num[0]);
		set.add(single);
		results.add(single);
		for(int i = 1; i < num.length;i++){
			results = calculateSubsets(results, num[i]);
		}
		List<Integer> empty = new ArrayList<Integer>();
		results.add(empty);
		return results;
	}
	
	public static List<List<Integer>> calculateSubsets(List<List<Integer>> results,int target){
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		for(int i = 0; i < results.size(); i++){
			List<Integer> t = new ArrayList<Integer>(results.get(i));
			t.add(target);
			if(!set.contains(t)){
				temp.add(t);
				set.add(t);
			}
		}
		results.addAll(temp);
		List<Integer> single = new ArrayList<Integer>();
		single.add(target);
		if(!set.contains(single)){
			set.add(single);
			results.add(single);
		}
		return results;
	}
	
	public static void main(String[] args){
		int[] S = {1,2,3};
		System.out.println(subsetsWithDup(S));
	}
	
}
