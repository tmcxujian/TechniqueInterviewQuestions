package CrackCodeInterView;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String>{
		public static String sortChars(String str){
			char[] c = str.toCharArray();
			Arrays.sort(c);
			return new String(c);
		}
		
		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s2));
		}
}
