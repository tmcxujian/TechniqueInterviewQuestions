package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 * @author xujian
 * Word ladder II
 */
public class LeetCode_126 {

	public static List<List<String>> findLadders(String start, String end,
			Set<String> dict){
		if(start == null || end == null || start.length() == 0 || end.length() == 0 ||
				start.length() != end.length()){
			return null;
		}
		LinkedList<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		queue.add(start);
		int curNum = 0;
		int lastNum = 1;
		int level = 1;
		int minLength = 0;
		while(!queue.isEmpty()){
			String cur = queue.poll();
			lastNum--;
			for(int i = 0; i < cur.length(); i++){
				char[] c = cur.toCharArray();
				for(char temp = 'a'; temp < 'z'; temp++){
					c[i] = temp;
					String s = new String(c);
					if(s.equals(end)){
						minLength++;
					}
					if(dict.contains(s) && !visited.contains(s)){
						curNum ++;
						queue.offer(s);
						visited.add(s);						
					}
				}
			}
			if(lastNum == 0){
				lastNum = curNum;
				curNum = 0;
				level++;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
