package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author xujian
 * Combination Sum
 */
public class LeetCode_39 {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(candidates == null || candidates.length == 0){
			return result;
		}
		Arrays.sort(candidates);
		/*int i = 0;//decrease effient
		for(; i < candidates.length; i++){
			if( candidates[i] > target){
				break;
			}
		}
		int[] A = Arrays.copyOfRange(candidates, 0, i);*/
		helper(candidates, target, 0, temp,result);
	    return result;
	}
	
	public static void helper(int[] candidates, int target, int start, List<Integer> temp,
			List<List<Integer>> result){
		if(target < 0){
			return;
		}
		else if(target == 0){
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = start; i < candidates.length; i++){
			while(i > 0 && candidates[i] == candidates[i-1]){
				i++;
			}
			temp.add(candidates[i]);
			int newTarget = target - candidates[i];
			helper(candidates, newTarget, i, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
	//还有一种多一个vistied的boolean数组，用来记录该数字是否被访问过
	
	public static void main(String[] args) {
		int[] A = {1};
		List<List<Integer>> result = combinationSum(A, 1);
		System.out.println(result.get(0).get(0));
	}

}
