package LeetCode;

import java.util.HashMap;

/**
 * Minimum Window Substring
 * @author xujian
 *
 */
public class LeetCode_76 {
	//应用两个窗口,当count和T.length 相等的时候，说明window已经够长了，就开始缩短
	public static String minWindow(String S, String T) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < T.length(); i++){
			if(map.containsKey(T.charAt(i))){
				map.put(T.charAt(i),map.get(T.charAt(i))+1);
			}
			else{
				map.put(T.charAt(i), 1);
			}
		}
		int start = 0;
		int end = 0;
		int count = 0;
		int min = Integer.MAX_VALUE;
		String minWindow = "";
		HashMap<Character, Integer> found = new HashMap<Character, Integer>();
		while(end < S.length()){
			if(map.containsKey(S.charAt(end))){
				if(found.containsKey(S.charAt(end))){
					if(found.get(S.charAt(end)) < map.get(S.charAt(end))){					
						count++;
					}
					found.put(S.charAt(end), found.get(S.charAt(end))+1);
				}
				else{
					found.put(S.charAt(end),1);
					count++;
				}
			}
			if(count == T.length()){
				char sc = S.charAt(start);
				while(!found.containsKey(sc) || found.get(sc) > map.get(sc)){
					if(found.containsKey(sc) && found.get(sc) > map.get(sc)){
						found.put(sc, found.get(sc)-1);						
					}
					start++;				
					sc = S.charAt(start);
				}
				if(min > (end - start + 1)){
					min = end - start + 1;
					minWindow = S.substring(start, end + 1);
				}
			}
			end++;
		}
        return minWindow;
    }
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}

}
