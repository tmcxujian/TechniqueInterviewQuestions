package LeetCode;
/**
 * Binary Search Tree
 * @author xujian
 *
 */
public class LeetCode_96 {

	 public static int numTrees(int n) {
		 int[] F = new int[n+1];
		 F[0] = 1;
		 for(int i = 1; i <= n; i++){
			 int temp = i >> 1;
			 for(int j = 1; j <= temp; j++){
				 F[i] += (F[i-j]*F[j-1]);
			 }
			 F[i] <<= 1;
			 if(i % 2 != 0){
				 F[i] += F[temp] * F[temp];
			 }
		 }
		 return F[n];
	 }
	 
	 public static void main(String[] args){
		 System.out.println(numTrees(3));
	 }
}
