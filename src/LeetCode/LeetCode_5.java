package LeetCode;


/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author xujian
 * Longest Palindromic Substring
 */

public class LeetCode_5 {
	
	public static String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		for(int i = 0; i < s.length(); i++){
			int len1 = expandFromCenter(s, i, i);
			int len2 = expandFromCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len > end - start){
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandFromCenter(String s, int start, int end){
		int L = start;
		int R = end;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
			L--;
			R++;
		}
		return R - L - 1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbba"));
	}

}
