package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_118 {
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows <= 0){
			return result;
		}
		return generation(numRows, result);
	}
	
	public static List<List<Integer>> generation(int numRows, List<List<Integer>> list){
		if(numRows == 1){
			List<Integer> l = new ArrayList<Integer>();
			l.add(1);
			list.add(l);
			return list;
		}
		List<List<Integer>> result = generation(numRows-1, list);
		List<Integer> ll = result.get(numRows-1-1);
		List<Integer> newList = new ArrayList<Integer>();
		newList.add(1);
		for(int i = 0; i < ll.size() - 1; i++){
			int temp = ll.get(i) + ll.get(i + 1);
			newList.add(temp);
		}
		newList.add(1);
		result.add(newList);
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(generate(5));
	}
}
