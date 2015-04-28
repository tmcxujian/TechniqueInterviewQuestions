package LeetCode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases. For example,
 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
 * palindrome.
 * 
 * @author xujian
 *
 */
public class LeetCode_125 {
	public static boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s
					.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: anama";
		System.out.println(validPalindrome(s));
	}
}
