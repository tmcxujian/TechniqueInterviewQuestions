package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP address
 * @author xujian
 * Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 */
public class LeetCode_93 {
	
	public static List<String> restoreIpAddresses(String s) {
		ArrayList<String> list = new ArrayList<String>();
		if(s.length() < 4 || s.length() > 12){
			return list;
		}
		dfs(list,s,0,"");
		return list;
	}
	
	//num 代表了还需要多少个域未完成
	public static void dfs(ArrayList<String> list, String s, int num, String temp){
		if(num == 3 && isValidAddress(s)){
			list.add(temp + s);
			return;
		}
		for(int i = 1; i < 4 && i < s.length(); i++){
			String str = s.substring(0, i);
			if(isValidAddress(str)){
				dfs(list, s.substring(i), num+1, temp + str + '.');
			}
		}
	}
	
	public static boolean isValidAddress(String s){
		if(s.charAt(0) == '0'){
			//比较字符串String需要用equals()，而不是用==
			//s.charAt(i) == 'u' 这个是OK的,就是在比较String的时候要注意
			return s.equals("0");
		}
		int res = Integer.parseInt(s);
		return (res > 0 && res <= 255);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0000";
		System.out.println(restoreIpAddresses(s));
	}

}
