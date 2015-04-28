package LeetCode;

import java.util.Set;

/**
 * Word Break
 * @author xujian
 *
 */
public class LeetCode_139 {

	public static boolean wordBreak(String s, Set<String> dict){
		boolean[] F = new boolean[s.length()+1];
		F[0] = true;
		for(int i = 0; i < s.length(); i++){
			if(!F[i]){
				continue;
			}
			for(String str : dict){
				int len = str.length();
				int end = len + i;
				if(end > s.length()){
					continue;
				}
				if(F[end]){
					continue;
				}
				if(s.substring(i, end).equals(str)){
					F[end] = true;
				}
			}
		}
		return F[s.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
