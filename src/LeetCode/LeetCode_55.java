package LeetCode;
/**
 * Jump Game
 * @author xujian
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class LeetCode_55 {

	//用maxReach来记录能到达的最远距离
	//用step来记录是否终止
	public static boolean canJump(int[] A) {
		if(A.length <= 1){
			return true;
		}
		int maxReach = 0;
		for(int i = 0; i <= maxReach && i < A.length; i++){
			int temp = i + A[i];
			if(temp > maxReach){
				maxReach = temp;
			}
		}
		return maxReach >= A.length - 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		int[] B = {3,2,1,0,4};
		System.out.println(canJump(A));
		System.out.println(canJump(B));
	}

}
