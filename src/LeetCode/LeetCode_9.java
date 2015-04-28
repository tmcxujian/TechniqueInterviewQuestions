package LeetCode;

public class LeetCode_9 {
	public static boolean isPalindrome(int x){
		if (x < 0){
			return false;
		}
		int div = 1;
		while (x / div >= 10){
			div *= 10;
		}//get the first digit
		while (x != 0){
			int a = x / div;
			int b = x % 10;
			if (a != b){
				return false;
			}			
			x = (x % div) / 10;
			//x % div get rid of first digit 
			//(x % div) / 10 get rid of last digit
			div /= 100;
			//一次要踢掉两个位
		}
		return true;
	}
	
	//if the number is palidrom, 131 for example
	//multiple every digit that would double the whole number
	public static boolean isPalidrome2(int x){
		if (x < 0){
            return false;
        }
        int result = 0;
        int i = x;
		while(i != 0){
			int temp = i % 10;
			i = i / 10;
			result = result * 10 + 2 * temp;
		}
		return (result == 2 * x);
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome(-2147447412));
	}
}
