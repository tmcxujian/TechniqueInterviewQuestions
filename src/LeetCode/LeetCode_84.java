package LeetCode;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 * @author xujian
 * difference for this one and largest container : 
 * this has relations with minimal number in the middle
 */

public class LeetCode_84 {
	
	public static int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int n = height.length;
		int maxArea = 0;
		while(i < n){
			if(stack.isEmpty() || height[i] >= height[stack.peek()]){
				stack.push(i++);
			}
			else{
				int temp = stack.peek();
				stack.pop();
				int maxSoFar = height[temp] * (stack.isEmpty() ? i : 
					i - stack.peek() - 1);
				if(maxSoFar > maxArea){
					maxArea = maxSoFar;
				}
			}
		}
		while(!stack.isEmpty()){
			int h = height[stack.pop()];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, h*width);		
		}
		return maxArea;
    }
	
	public static void main(String[] args){
		int[] height = {2,1,5,6,2,3};
		int[] A = {1,2,3,4,5};
		System.out.println(largestRectangleArea(A));
		System.out.println(largestRectangleArea(height));
	}
	
}
