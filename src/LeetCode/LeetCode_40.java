package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author xujian
 * Combination SumII
 */
public class LeetCode_40 {
	
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(num == null || num.length == 0){
			return result;
		}
		Arrays.sort(num);
		helper(num, target, 0, temp ,result);
	    return result;
    }
	
	//和上面一道题，区别就在helper()
	//注意自己的if/else if statement的逻辑顺序
	public static void helper(int[] candidates, int target, int start, List<Integer> temp,
			List<List<Integer>> result){
		if(target == 0){
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		else if(target < 0 || start >= candidates.length){
			return;
		}
		for(int i = start; i < candidates.length; i++){
			while(i > start && candidates[i] == candidates[i-1]){
				i++;
			}
			temp.add(candidates[i]);
			int newTarget = target - candidates[i];
			helper(candidates, newTarget, i + 1, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args){
		int[] A = {1};
		List<List<Integer>> result = combinationSum2(A, 1);
		System.out.println(result.get(0).get(0));
	}
}
