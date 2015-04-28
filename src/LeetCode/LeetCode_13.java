package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author xujian
 * Roman to Integer
 */
public class LeetCode_13 {
	//Roman to Integer matching map
	private static Map<Character,Integer> map = new HashMap<Character, Integer>(){{
		put('I',1);
		put('V',5);
		put('X',10);
		put('L', 50); 
		put('C', 100); 
		put('D', 500);
        put('M', 1000);
	}};
	
	//combining with additive notation & subtractive notation
	//从左向右，逢小就加本身，大的话，就减去两倍的前面单位
	public static int romanToInt(String s){
		int temp = map.get(s.charAt(0));
		int result = 0;
		for (int i = 0; i < s.length(); i++){
			int a = map.get(s.charAt(i));
			if(a <= temp){
				result += a;
				temp = a;
			} else{
				result = result + a - 2 * temp;
			}
		}
		return result;
	}
	
	public int romanToInt2(String s) {
		   int prev = 0, total = 0;
		   for (char c : s.toCharArray()) {
		      int curr = map.get(c);
		      total += (curr > prev) ? (curr - 2 * prev) : curr;
		      prev = curr;
		}
		   return total;
		}
	
	public static void main(String[] args){
		String s = "MCM";
		System.out.println(romanToInt(s));
	}
}
