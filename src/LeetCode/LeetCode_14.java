package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author xujian
 * Longest Common Prefix
 */

public class LeetCode_14 {
   
	//先找出最小的长度那个
	//在根据最小长度去比较
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		StringBuilder result = new StringBuilder();
		int shortString = strs[0].length();
		for (int i = 0; i < strs.length; i++){
			shortString = (strs[i].length() > shortString) ? shortString :
				strs[i].length();
		}
		for (int i = 0; i < shortString; i++){
			char c = strs[0].charAt(i);
			for(int j = 0; j < strs.length; j++){
				char ch = strs[j].charAt(i);
				if(ch != c){
					return result.toString();
				}
			}
			result.append(c);
		}
		return result.toString();
	}
	
	//use recursion to solove this problem
	public static String longestCommonPrefix2(String[] strs) {
	    if(strs.length==0) return "";
	    if(strs.length==1) return strs[0];
	    String res = "";   
	    String first = strs[0];
	    String[] rest = Arrays.copyOfRange(strs,1,strs.length);
	    String ss = longestCommonPrefix(rest);
	    for (int i = 0; i < Math.min(first.length(),ss.length()); i++) {
	        if(first.charAt(i)!=ss.charAt(i)){
	            break;
	        }
	        res+=first.charAt(i);
	    }
	    return res;
	}
	
	//Use hashset
	public static String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0)
			return "";

		int size = strs.length;
		int j = 0;
		int minlength = strs[0].length();

		// find the min length of strings
		for (String s : strs) {
			if (s.length() < minlength) {
				minlength = s.length();
			}
		}
		// take substrings, put into a HashSet. if HashSet size >1, reduce the
		// lengh of substrings;
		while (j < minlength) {
			HashSet<String> h = new HashSet<String>();
			for (int i = 0; i < size; i++) {
				h.add(strs[i].substring(0, minlength - j));
				if (h.size() > 1)
					break;
			}
			if (h.size() == 1)
				return strs[0].substring(0, minlength - j);
			j++;

		}
		return "";
	}
	
	public static void main(String[] args) {
		String[] s = {"aab","aaa","acb"};
		String[] cs = {"a"};
		System.out.println(longestCommonPrefix3(s));
	}

}
