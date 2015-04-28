package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * @author xujian
 * Word Ladder I
 */
public class LeetCode_127 {
	public static int ladderLength(String start, String end, Set<String> dict) {
		if(start == null || end == null || start.length() == 0 || end.length() == 0 ||
				start.length() != end.length()){
			return 0;
		}
		LinkedList<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		queue.add(start);
		int curNum = 0;
		int lastNum = 1;
		int level = 1;
		while(!queue.isEmpty()){
			String cur = queue.poll();
			lastNum--;
			for(int i = 0; i < cur.length(); i++){
				char[] c = cur.toCharArray();
				for(char temp = 'a'; temp < 'z'; temp++){
					c[i] = temp;
					String s = new String(c);
					if(s.equals(end)){
						return level + 1;
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
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(ladderLength("hit", "cog", set));
		//{"hot","dot","dog","lot","log"};
	}

}
