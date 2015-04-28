package LeetCode;
/**
 * you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * @author xujian
 * Best Time to Buy and Sell Stock 
 */
public class LeetCode_121 {

	//using DP techniques
	public static int maxProfit(int[] prices){
		//use min and max to keep track of maximize value in prices.
		//one thing to pay attention is sold day j > bought day i
		if(prices.length <= 1){
			return 0;
		}
		int min = prices[0];
		int max = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] < min){
				min = prices[i];
			}
			result = prices[i] - min;
			if(max < result){
				max = result;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] prices = {1,2,5,3};
		System.out.println(maxProfit(prices));
	}

}
