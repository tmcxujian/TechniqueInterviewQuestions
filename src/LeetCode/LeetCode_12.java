package LeetCode;

/**
 * 
 * @author xujian
 * Integer to Roman
 */

public class LeetCode_12 {

	private static final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40,
			10, 9, 5, 4, 1 };
	
	private static final String[] symbols = { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };
	
	//对应着两个数组：values/symbols,当该单位除数大于一，才处理
	public static String intToRoman(int num){
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (num != 0){
			int a = num / values[i];
			while(a > 0){
				result.append(symbols[i]);
				a--;
			}
			num = num % values[i];
			i++;
		}
		return result.toString();
	}
	
	public static String intToRoman2(int num){
		StringBuilder roman = new StringBuilder();
		int i = 0;
		while (num > 0) {
			int k = num / values[i];
			for (int j = 0; j < k; j++) {
				roman.append(symbols[i]);
				num -= values[i];
			}
			i++;
		}
		return roman.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(49));
	}

}
