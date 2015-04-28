package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author xujian
 * Longest Substring Without Repeating Characters
 */

public class LeetCode_3 {

	//没看懂
	public static int lengthOfLongestSubstring(String s){
		int[] table = new int[256];
		Arrays.fill(table, -1);
		int i = 0;
		int maxLength = 0;
		for (int j = 0; j < s.length(); j++){
			if(table[s.charAt(j)] >= i){
				i = table[s.charAt(j)] + 1;
			}
			table[s.charAt(j)] = j;
			maxLength = Math.max(j-i+1,maxLength);
		}
		return maxLength;
	}
	
	public static int lengthOfLongestSubstring2(String s){
		boolean[] table = new boolean[256];
		Arrays.fill(table, false);
		int i = 0;
		int maxLength = 0;
		for (int j = 0; j < s.length(); j++){
			while (table[s.charAt(j)]){
				table[s.charAt(i)] = false;
				i++;
			}
			table[s.charAt(j)] = true;
			maxLength = Math.max(maxLength,j-i+1);
		}
		return maxLength;
	}
	
	//应用两个窗口,移动两个窗口
	public static int lengthOfLongestSubstring3(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		HashSet<Character> set = new HashSet<Character>();
		int end = 0;
		int start = 0;
		int max = 0;
		while(end < s.length()){
			if(set.contains(s.charAt(end))){
				if(max < end - start){
					max = end - start;
				}
				//如果相等说明star-end之间已经开始重复了
				while(s.charAt(end) != s.charAt(start)){
					set.remove(s.charAt(start));
					start++;
				}
				start++;
			}
			else{
				set.add(s.charAt(end));
			}
			end++;
		}
		return max > end - start ? max : end -start;
	}
	
	public static void main(String[] args) {
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
