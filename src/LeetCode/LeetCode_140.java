package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Word Break II
 * @author xujian
 *
 */
public class LeetCode_140 {

	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String>[] F = new ArrayList[s.length()+1];
		F[0] = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			if(F[i] == null){
				continue;
			}
			for(String str : dict){
				int len = str.length();
				int end = len + i;
				if(end > s.length()){
					continue;
				}
				if(s.substring(i, end).equals(str)){
					if(F[end] == null){
						F[end] = new ArrayList<String>();
					}					
					F[end].add(str);
				}
			}
		}
		//above we get the arraylist containing all possible words
		//below we should deal with this arraylist
		List<String> result = new ArrayList<String>();
		if(F[s.length()] == null){
			return result;
		}
		List<String> temp = new ArrayList<String>();
		dfs(F,s.length(),result,temp);
        return result; 
    }
	
	private static void dfs(List<String>[] F, int end, List<String> result,
			List<String> temp) {
		// TODO Auto-generated method stub
		if(end <= 0){
			String path = temp.get(temp.size()-1);
			for(int i = temp.size()-2; i >= 0; i--){
				path += " " + temp.get(i);
			}
			result.add(path);
			return;
		}
		for(String str : F[end]){
			temp.add(str);
			dfs(F,end-str.length(),result,temp);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
