package CrackCodeInterView;
/**
 * Implement an algorithm to determine if a String has all unique Characters
 * @author xujian
 * Without using extra data structures
 */
public class Chapter1_1 {
	public static boolean isUniqueChracterString(String s){
		if (s.length() > 128) {
			return false;
		}
		boolean[] result = new boolean[256];
		for(int i = 0; i < s.length(); i++){
			if(result[s.charAt(i)]){
				return false;
			}
			result[s.charAt(i)] = true;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "helao";
		System.out.println(isUniqueChracterString(s));
	}
}
