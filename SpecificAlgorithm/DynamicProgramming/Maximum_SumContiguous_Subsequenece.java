package DynamicProgramming;
/**
 * LeetCode_53
 * @author xujian
 *
 */
public class Maximum_SumContiguous_Subsequenece {
	
	public static int maximum(int[] array){
		int sum = 0;
		int maxSoFar = 0;
		for(int i = 0; i < array.length; i++){
			maxSoFar = Math.max(maxSoFar + array[i], array[i]);
			sum = Math.max(sum, maxSoFar);
		}
		return sum;
	}
	
	public static void main(String[] args){
		int[] A = {1,-1,1};
		System.out.println(maximum(A));
	}
}
