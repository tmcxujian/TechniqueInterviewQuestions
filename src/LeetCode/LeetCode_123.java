package LeetCode;
/**
 * You have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author xujian
 * Best Time to Buy and Sell Stock III 
 */

public class LeetCode_123 {
	//Maxprofix = max(Max(0,i) + Max(i+1, n))  0<=i<n
	//DP or divide and conquer
	public static int maxProfit(int[] prices){
		if(prices.length <= 1){
			return 0;
		}
		int[] maxProfitFromLeft = new int[prices.length];
		int[] maxProfitFromRight = new int[prices.length];
		int min = Integer.MAX_VALUE;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < min){
				min = prices[i];
			}
			int temp = prices[i] - min;
			if(temp > result){
				result = temp;
			}
			maxProfitFromLeft[i] = result;
		}
		System.out.println();
		int max = Integer.MIN_VALUE;
		result = Integer.MIN_VALUE;
		for(int i = prices.length - 1; i >= 0; i--){
			if(prices[i] > max){
				max = prices[i];
			}
			int temp = max - prices[i];
			if(temp > result){
				result = temp;
			}
			maxProfitFromRight[i] = result;
		}
		int maxProfit = Integer.MIN_VALUE;
		for(int i = 0; i < prices.length - 1; i++){
			//玛德 要注意这种大小关系啊！
			if(maxProfit < (maxProfitFromLeft[i] + maxProfitFromRight[i+1])){
				maxProfit = maxProfitFromLeft[i] + maxProfitFromRight[i+1];
			}
		}
		if(maxProfit < maxProfitFromRight[0]){
			maxProfit = maxProfitFromRight[0];
		}
		return maxProfit;
	}
	
	public static void main(String[] args){
		int[] A = {2,1,2,0,1};
		System.out.println(maxProfit(A));
	}
}
