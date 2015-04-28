package LeetCode;
/**
 * Implement atoi to convert a string to an integer.
 * @author xujian
 * String to Integer (atoi)
 */

public class LeetCode_8 {
	public static int atoi(String str) {
		int i = 0;
		int j = str.length();
		int sign = 1;
		int result = 0;
		while (i < j && Character.isWhitespace(str.charAt(i))){
			i++;
		}
		if (i < j && str.charAt(i) == '+'){
			i++;
		}
		else if (i < j && str.charAt(i) == '-'){
			sign = -1;
			i++;
		}
		while (i < j && Character.isDigit(str.charAt(i))){
			int temp = Character.getNumericValue(str.charAt(i));
			if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 &&
					temp >= 8)){
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + temp;
			i++;
		}
		return sign * result;
	}
}
