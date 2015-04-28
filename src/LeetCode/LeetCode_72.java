package LeetCode;
/**
 * Edit Distance
 * @author xujian
 *
 */
public class LeetCode_72 {
	
	public static void main(String[] args){
		String word1 = "Hello";
		String word2 = "He";
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2){
		if(word1.length() == 0){
			//delete
			return word2.length();
		}
		else if(word2.length() == 0){
			//insert
			return word1.length();
		}
		int[][] F = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i <= word2.length(); i++){
			F[0][i] = i;
		}
		for(int i = 0; i <= word1.length(); i++){
			F[i][0] = i;
		}
		for(int i = 1; i <= word1.length(); i++){
			for(int j = 1; j <= word2.length(); j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					F[i][j] = F[i-1][j-1];
				}
				else{
					//这里都没有考虑到不通操作的cost问题
					F[i][j] = 1 + Math.min(F[i-1][j], Math.min(F[i][j-1], 
							F[i-1][j-1]));
				}
			}
		}
		return F[word1.length()][word2.length()];
	}
	
	
}
