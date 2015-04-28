package LeetCode;

/**
 * Given an input string s, reverse the string word by word. For example, given
 * s = "the sky is blue", return "blue is sky the".
 * 
 * @author xujian
 *
 */
public class LeetCode_151 {

	public static String reverseWord(String s) {
		StringBuilder reversed = new StringBuilder();
		// Here j = s.length() exceeds the scope of s, but it will use substring
		int j = s.length();
		for (int i = s.length() - 1; i > 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					// excepte the beginning we do not append a space
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}
}
