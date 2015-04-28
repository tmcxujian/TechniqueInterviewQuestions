package LeetCode;

/**
 * Palindrome Partitioning 
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode_131 {
	
	public static List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<List<String>>();
		int len = s.length();
		if(len <= 0){
			return list;
		}
		boolean[][] f = new boolean[len][len];
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				f[i][j] = false;
			}
			f[i][1] = true;
		}
		return null;
    }
	
	public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.println(partition(s));
	}

}
