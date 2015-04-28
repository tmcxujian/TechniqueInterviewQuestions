package LeetCode;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * @author xujian
 *
 */
public class LeetCode_32 {
	
	public static int longestValidParentheses(String s){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(i);
			}
			else{
				int topIndex = stack.peek();
				if(topIndex >= 0 && s.charAt(topIndex) == '('){
					stack.pop();
					res = Math.max(res, i - stack.peek());			
				}
				else{
					stack.push(i);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		String s = "))))((()((";
		String s1 = "()";
		System.out.println(longestValidParentheses(s));
	}
}
