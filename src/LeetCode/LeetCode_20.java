package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 * @author xujian
 * Valid Parentheses
 */
public class LeetCode_20 {
	
	public static final Map<Character,Character> map = new 
			HashMap<Character,Character>(){{
		put('(', ')');
        put('{', '}');
        put('[', ']');
	}};
	
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(map.containsKey(c)){
				stack.push(c);
			}
			else if(stack.isEmpty() || map.get(stack.pop()) != c){
				return false;
			}
		}
		return stack.isEmpty();
	}

}
