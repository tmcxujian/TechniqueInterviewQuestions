package LeetCode;
/**
 * 
 * @author xujian
 * Multiply Strings
 */
public class LeetCode_43 {
	
	//use an extra space to keep track each place's information
	public static String multiply(String num1, String num2){
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		int[] result = new int[num1.length() + num2.length()];
		for(int i = 0; i < num1.length(); i++){
			int a = num1.charAt(i) - '0';
			for(int j = 0; j < num2.length(); j++){
				int b = num2.charAt(j) - '0';
				result[i+j] += a * b;
			}
		}
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < result.length; i++){
			int digit = result[i] % 10;
			int carry = result[i] / 10;
			str.insert(0,digit);
			if(i < result.length - 1){
				result[i+1] += carry;
			}
		}
		while(str.length() > 0 && str.charAt(0) == '0'){
			str.deleteCharAt(0);
		}
		return str.length() == 0 ? "0" : str.toString();
	}
	
	public static void main(String[] args){
		String num1 = "123";
		String num2 = "456";
		System.out.println(multiply(num1, num2));
	}
}
