package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repeated DNA Sequences 
 * @author xujian
 *
 */
public class LeetCode_187 {

	//这个问题首先产生的memory exceed问题在于我的key如果是一个String，长度为10
	//那么需要的空间很大，取代的方法是用一个Integer代替
	public static List<String> findRepeatedDnaSequences(String s) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<String> list = new ArrayList<String>();
		if(s.length() < 10){
			return list;
		}
		for(int i = 0; i < s.length() - 9; i++){
			int v = getV(s, i);
			if(!map.containsKey(v)){
				map.put(v,1);
			}
			else{
				//这里要注意重复的String只需要一次，以后就在也不用了..
				//也可以这里Map<Integer,boolean>,用boolean得话可以少很多空间
				if(map.get(v) == 1){
					list.add(s.substring(i, i+10));
					int temp = map.get(v) + 1;
					map.put(v, temp);
				}
			}
		}
        return list;
    }
	
	public static int getV(String s, int index) {
		int v = 0;
		for (int i = index; i < index + 10; i++) {
			int vv = 0;
			if (s.charAt(i) == 'A')
				vv = 0;
			else if (s.charAt(i) == 'C')
				vv = 1;
			else if (s.charAt(i) == 'G')
				vv = 2;
			else
				vv = 3;
			v <<= 2;
			v |= vv;
		}
		return v;
	}
	
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(findRepeatedDnaSequences(s));
	}

}
