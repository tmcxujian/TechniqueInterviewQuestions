package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author xujian
 * Letter Combinations of a Phone Number
 */

public class LeetCode_17 {
	public static int[] digits = {2,3,4,5,6,7,8,9};
	public static String[] letters = {"abc","def","ghi","jkl","mno",
			"pqrs","tuv","wxyz"};
	
	//This is BFS algorithm without using recursion
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if(digits.length() == 0){
			result.add("");
			return result;
		}		
		String s = letters[Character.getNumericValue(digits.charAt(0))-2];
		for (int i = 0; i < s.length(); i++){
			result.add(Character.toString(s.charAt(i)));
		}
		for(int i = 1; i < digits.length(); i++){
			int a = Character.getNumericValue(digits.charAt(i));
			result = combinations(result, letters[a-2]);
		}
        return result;
    }
	
	public static List<String> combinations(List<String> str1, String str2){
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < str1.size(); i++){
			for(int j = 0; j < str2.length(); j++){
				StringBuilder str = new StringBuilder();
				str.append(str1.get(i));
				str.append(str2.charAt(j));
				result.add(str.toString());
			}
		}
		return result;
	}
	
	//This is DFS algorithm using recursion
	public static List<String> letterCombinations1(String digits){
		List<String> result = new ArrayList<String>();
		if(digits.length() == 0){
			result.add("");
			return result;
		}
		//这一步很关键...就是每次都减少一个char
		//每次都是一个子问题，返回的temp可以累加
		List<String> temp = letterCombinations1(digits.substring(1));
		String s = letters[Character.getNumericValue(digits.charAt(0))-2];
		for(int j = 0; j < s.length(); j++){
			for (int t = 0; t < temp.size(); t++){
				result.add(s.charAt(j) + temp.get(t));
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		List<String> x = new ArrayList<String>();
		x.add("a");
		x.add("b");
		x.add("c");
		System.out.println(letterCombinations1("234"));
		System.out.println(combinations(x,"def"));
	}
}
