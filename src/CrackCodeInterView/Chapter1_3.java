package CrackCodeInterView;

import java.util.Arrays;

import javax.naming.ldap.SortControl;

/**
 * Decide if one string is permutation of another string
 * @author xujian
 *
 */
public class Chapter1_3 {

	//permutation意思是包含同样的字符,利用的是长度，还有字符数量的特性
	//与之前那个String rotation不太一样..
	public static boolean isPermutation(String s1, String s2){
		return sort(s1).equals(sort(s2));
	}
	
	public static String sort(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean isStringRotation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		String s = s2 + s2;
		return s.contains(s1);
	}
	
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;  
		}
		  
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
		    if (--letters[c] < 0) {
		    	return false;
		    }
		}
		  
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "llohe";
		System.out.println(isStringRotation(s1, s2));
	}

}
