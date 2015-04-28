package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Anagram
 * @author xujian
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */
public class LeetCode_49 {

	//Hashmap of hashmap itself
	public static List<String> anagrams(String[] strs){
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < strs.length; i++){
			char[] old = strs[i].toCharArray();
			Arrays.sort(old);
			String s = new String(old);
			if(map.containsKey(s)){
				if(map.get(s) != -1){
					list.add(strs[map.get(s)]);
					map.put(s, -1);
				}
				list.add(strs[i]);
			}
			else{
				map.put(s, i);
			}
		}
		return list;
	}
	
	
	//Hashmap contains ArrayList
	public ArrayList<String> anagrams2(String[] strs) {
	    ArrayList<String> res = new ArrayList<String>();
	    if(strs == null || strs.length == 0)
	        return res;
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(int i=0;i<strs.length;i++)
	    {
	        char[] charArr = strs[i].toCharArray();
	        Arrays.sort(charArr);
	        String str = new String(charArr);
	        if(map.containsKey(str))
	        {
	            map.get(str).add(strs[i]);
	        }
	        else
	        {
	            ArrayList<String> list = new ArrayList<String>();
	            list.add(strs[i]);
	            map.put(str,list);
	        }
	    }
	    Iterator iter = map.values().iterator();
	    while(iter.hasNext())
	    {
	        ArrayList<String> item = (ArrayList<String>)iter.next();
	        if(item.size()>1)
	            res.addAll(item);
	    }
	    return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"and","dan"};
		System.out.println(anagrams(str));
	}

}
