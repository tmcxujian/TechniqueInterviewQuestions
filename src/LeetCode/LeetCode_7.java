package LeetCode;
/**
 * reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author xujian
 * Reverse Integer 
 */

public class LeetCode_7 {

	public static int reverse(int x) {
		int result = 0;
		int temp = 0;
		while (x != 0){
			temp = x % 10;
			if (Math.abs(result) > Integer.MAX_VALUE / 10){
				return 0;
			}
			result = result * 10 + temp;
			x /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int x = 	-2147483648;
		System.out.println(reverse(x));
	}

}
