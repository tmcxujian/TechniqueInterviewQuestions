package LeetCode;

/**
 * Validate if a given string is numeric. Some examples: "0" 􏰀 true "0.1" 􏰀
 * true "abc" 􏰀 false
 * 
 * @author xujian String could be divided into four parts: leading spaces -
 *         sign'+-' - number - trailing spaces Number could be separated into
 *         three parts: Integer - Decimal point - fraction part
 */

public class LeetCode_65_ValidNumberWithoutExponent {

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
		while (i < j && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return isNumeric && i == j;
	}

	public static void main(String[] args) {
		System.out.println(validNumber("0.11a"));
	}
}
