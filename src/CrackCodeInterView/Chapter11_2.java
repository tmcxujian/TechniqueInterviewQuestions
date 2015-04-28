package CrackCodeInterView;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Write a sort method to sort array so that all anagrams are next to each other
 * @author xujian
 *
 */
public class Chapter11_2 {
	
	public static void sortSimplifyVersion(String[] array){
		Arrays.sort(array,new AnagramComparator());
	}
	
	public static void sort(String[] array){
		Hashtable<String, LinkedList<String>> table = new 
				Hashtable<String, LinkedList<String>>();
		for(String s : array){
			String temp = AnagramComparator.sortChars(s);
			if(!table.containsKey(temp)){
				table.put(temp, new LinkedList<String>());
			}
			table.get(temp).push(s);
			//table.get(temp).add(s);
		}
		int index = 0;
		for(String s : table.keySet()){
			LinkedList<String> list = table.get(s);
			for(String str : list){
				array[index] = str;
				index++;
			}
		}
	}
}
