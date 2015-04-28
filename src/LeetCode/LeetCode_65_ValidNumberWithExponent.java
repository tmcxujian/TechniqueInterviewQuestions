package LeetCode;

/**
 * A number could contain an optional exponent part, 
 * which is marked by a character ‘e’ followed by a whole number (exponent). 
 * For example, “1e10” is numeric. 
 * Modify the above code to adapt to this new requirement.
 * @author xujian
 *
 */
public class LeetCode_65_ValidNumberWithExponent {
	
	public static boolean validNumber(String s) {
		int i = 0;
		int j = s.length();
		while (i < j && Character.isWhitespace(i)) {
			i++;
		}
		if (i < j && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			i++;
		}
		boolean isNumeric = false;
		while (i < j && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < j && s.charAt(i) == '.') {
			i++;
			isNumeric = false;
			while (i < j && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		if (isNumeric && i < j && s.charAt(i) == 'e') {
			isNumeric = false;
			i++;
			if (i < j && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				i++;
			}
			while (i < j && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < j && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return isNumeric && i == j;
	}
	
	public static void main(String[] args) {
		System.out.println(validNumber("0.11ea"));
	}
}
