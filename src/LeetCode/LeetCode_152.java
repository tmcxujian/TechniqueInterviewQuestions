package LeetCode;
/**
 * 
 * @author xujian
 * Maximum SubArray Product
 */
public class LeetCode_152 {
	
	public int maxProduct(int[] A) {
		int maxProduct = A[0];
		int minProduct = A[0];
		int maxAns = 0;
		for(int i = 0; i < A.length; i++){
			int mx = maxProduct;
			int mn = minProduct;
			maxProduct = Math.max(mx * A[i], Math.max(mn * A[i], A[i]));
			minProduct = Math.min(mx * A[i], Math.min(mn * A[i], A[i]));
			maxAns = Math.max(maxProduct, maxAns);
		}
		return maxAns;
	}
}
