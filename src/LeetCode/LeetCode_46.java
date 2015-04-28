package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * @author xujian
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 1
 * 12  &&  21
 * 312 && 132 && 123 && 321 & 231 & 213
 */

public class LeetCode_46 {
	
	public List<List<Integer>> permute2(int[] num){
		List<List<Integer>> results = new ArrayList<List<Integer>>();	
		List<Integer> solution = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		if(num.length == 0){
			return results;
		}
		for(int i : num){
			temp.add(i);
		}
		permute(results,solution,temp,num.length);
		return results;
	}
	
	public static void permute(List<List<Integer>> results, List<Integer> solution,
			List<Integer> temp, int length){
		//means every element is included
		if(length == solution.size()){
			results.add(new ArrayList<Integer>());
			return;
		}
		
		for(int i = 0; i < temp.size(); i++){
			int value = temp.remove(i);
			solution.add(value);
			permute(results, solution, temp, length);
			solution.remove(value);
			temp.add(i,value);
		}
	}
	

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();	
		List<List<Integer>> resultscopy = null;	
		if(num.length == 0){
			return results;
		}
		List<Integer> res = new ArrayList<Integer>();
		res.add(num[0]);
		results.add(res);
		resultscopy = results;
		for(int i = 1; i < num.length; i++){
			results = new ArrayList<List<Integer>>();
			//将这一步上面的list复制一遍，在中间夹缝里添加num[i]
			for(int j = 0; j < resultscopy.size(); j++){
				//这里是<=这样就可以嵌在头和尾
				for(int k = 0; k <= resultscopy.get(j).size();k++){
					res = new ArrayList<Integer>(resultscopy.get(j));
					res.add(k, num[i]);
					results.add(res);
				}
			}
			resultscopy = results;
		}
        return results;
    }
	
}
