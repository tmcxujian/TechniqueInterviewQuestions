package LeetCode;
/**
 * Distinct Subsequence
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * @author xujian
 *
 */
public class LeetCode_115 {

	public static void main(String[] args){
		String S = "b";
		String T = "a";
		System.out.println(numDistinct(S, T));
		String S1 = "rabbbit";
		String T1 = "rabbit";
		System.out.println(numDistinct(S1, T1));
	}
	
	public static int numDistinct(String S, String T) {
		if(T.length() == 0){
			return 1;
		}
		else if(S.length() == 0){
			return 0;
		}
		int[][] F = new int[S.length()+1][T.length()+1];
		//初始条件
		for(int i = 0; i < S.length(); i++){
			F[i][0] = 1;
		}
		for(int i = 1; i <= S.length(); i++){
			for(int j = 1; j <= T.length(); j++){
				if(S.charAt(i-1) == T.charAt(j-1)){
					F[i][j] = F[i-1][j-1] + F[i-1][j];
				}
				else{
					F[i][j] = F[i-1][j];
				}
			}
		}
        return F[S.length()][T.length()];
    }
	
}
