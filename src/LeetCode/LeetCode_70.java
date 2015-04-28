package LeetCode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * @author xujian
 * Climbing Stairs 
 */

public class LeetCode_70 {
	public int climbStairs(int n){
		if(n == 1 || n == 0){
			return n;
		}
		if(n == 2){
			return 2;
		}
		else{
			return climbStairs(n-1) + climbStairs(n-2);
		}
	}
	
	public int climbStairs2(int n){
		int q = 1;//base case f(2)
		int p = 1;//base case f(1)
		for (int i = 2; i <= n; i++){
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
}
