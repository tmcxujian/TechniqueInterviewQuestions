package LeetCode;
/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai).
 *  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) 
 *  and (i, 0). Find two lines, which together with x-axis forms a container, 
 *  such that the container contains the most water.
 *  Note: You may not slant the container.
 * @author xujian
 * Container with most water
 */
public class LeetCode_11 {
	
	public static int maxArea(int[] height){
		if(height.length == 0){
			return 0;
		}
		if(height.length == 1){
			return height[1];
		}
		int maxArea = 0;
		int i = 0;
		int j = height.length - 1;
		while(i < j){
			int temp = Math.min(height[i],height[j]) * (j - i);
			maxArea = Math.max(maxArea, temp);
			if(height[i] < height[j]){
				i++;
			}
			else{
				j--;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args){
		int[] A = {3,5,6,2};
		int[] B = {1,1};
		System.out.println(maxArea(A));
		System.out.println(maxArea(B));
	}
	
}
