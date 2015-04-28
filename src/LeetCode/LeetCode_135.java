package LeetCode;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @author xujian
 * Candy
 */
public class LeetCode_135 {

	public static int candy(int[] ratings){
		int result = ratings.length;
		int[] candy = new int[ratings.length];
		for(int i = 1; i < ratings.length; i++){
			if(ratings[i] > ratings[i-1]){
				candy[i] = candy[i-1] + 1;
			}
		}
		for(int i = ratings.length - 2; i >= 0; i--){
			if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]){
				candy[i] = candy[i+1] + 1;
			}
		}
		for(int i = 0; i < candy.length; i++){
			result += candy[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,2};
		System.out.println(candy(A));
	}

}
