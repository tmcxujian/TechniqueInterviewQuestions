package LeetCode;
/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * @author xujian
 * Interleaving of String
 */
public class LeetCode_97 {

	//basic recursion method will cause time limit Exceed
	public static boolean isInterleaveWithRecursion(String s1, String s2, String s3){
		if(s1.length() == 0){
			return s2.equals(s3);
		}
		if(s2.length() == 0){
			return s1.equals(s3);
		}
		if(s1.length() + s2.length() != s3.length()){
			return false;
		}
		return (s1.charAt(0) == s3.charAt(0) && 
				isInterleaveWithRecursion(s1.substring(1), s2, s3.substring(1)))
				|| (s2.charAt(0) == s3.charAt(0) && 
				isInterleaveWithRecursion(s1, s2.substring(1), s3.substring(1)));
	}
	
	public static boolean isInterleave(String s1, String s2, String s3){
		if(s1.length() == 0){
			return s2.equals(s3);
		}
		else if(s2.length() == 0){
			return s1.equals(s3);
		}
		boolean[][] F = new boolean[s1.length()+1][s2.length()+1];
		if(s1.length() + s2.length() != s3.length()){
			return false;
		}
		if(s3.length() != 0){
			if(s2.charAt(0) == s3.charAt(0)){
				F[0][1] = true;
			}
			if(s1.charAt(0) == s3.charAt(0)){
				F[1][0] = true;
			}
		}
		for(int i = 0; i <= s1.length(); ++i){
			for(int j = 0; j <= s2.length(); ++j){
				if(j > 0){
					if(F[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
						F[i][j] = true;
						continue;
					}
				}
				if(i > 0){
					if(F[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
						F[i][j] = true;
						continue;
					}
				}
			}
		}
		return F[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "";
		String s3 = "ab";
		String s4 = "a";
		System.out.println(isInterleave(s1, s2, s4));
		System.out.println(isInterleave(s1, s3, s4));
	}

}
