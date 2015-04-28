package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * @author xujian
 * 4Sum 
 */
public class LeetCode_18 {
	
	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(num.length < 4){
			return results;
		}
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++){
			for(int j = i + 1; j < num.length; j++){
				int[] numTemp = Arrays.copyOfRange(num, j, num.length);
				int[] temp = twoSum(numTemp, target-num[i]-num[j]);
				if(temp.length != 0){
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(temp[0]);
					list.add(temp[1]);
					results.add(list);
				}
			}
		}
		for (int i = results.size() - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (results.get(i).get(0) == results.get(j).get(0)
						&& results.get(i).get(1) == results.get(j).get(1)
						&& results.get(i).get(2) == results.get(j).get(2)) {
					results.remove(j);
					i--;
				}
			}
		}
        return results;
    }
	
	public static int[] twoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(target - array[i])) {
				return new int[] { target - array[i], array[i] };
			}
			map.put(array[i], i);
		}
		return new int[] {};
	}
	
	public static void main(String[] args){
		int[] num = {1,0,-1,0,-2,2,3,-3};
		int target = 0;
		System.out.println(fourSum(num, target));
	}
}
