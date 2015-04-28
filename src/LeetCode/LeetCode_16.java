package LeetCode;

import java.util.Arrays;

import javax.security.auth.x500.X500Principal;
/**
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author xujian
 * 3Sum Closest 
 */

public class LeetCode_16 {

	public static int threeSumClosest(int[] num, int target){
		if(num.length < 3){
			return 0;
		}
		Arrays.sort(num);
		int result = num[0] + num[1] + num[2];
		int sum = 0;
		int a = 0;
		int b = 1;
		int c = num.length - 1;
		while(a < num.length - 1){			
			b = a + 1;
			c = num.length - 1;
			while(b < c){				
				sum = num[a] + num[b] + num[c];
				if (sum == target){
					return sum;
				}
				else if(sum > target){
					c--;
				}
				else{
					b++;
				}
				result = (Math.abs(sum-target) < Math.abs(result - target)) ? sum : result;
			}
			a++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] num = {0,2,1,-3};
		int[] num1 = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(num1, target));
	}

}
