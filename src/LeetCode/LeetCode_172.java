package LeetCode;
/**
 * 
 * @author xujian
 * Factorial Trailing Zeroes
 */
public class LeetCode_172 {
	
	/*
	 * 10 is the product of 2 and 5. In n!, 
	 * we need to know how many 2 and 5, 
	 * and the number of zeros is the minimum of the number of 2 and the number of 5.
	 * Since multiple of 2 is more than multiple of 5, 
	 * the number of zeros is dominant by the number of 5.
	 */
	public static int trailingZeroes(int n) {
		//base case 2 * 5 = 10
		int count = 0;
		while(n > 1){
			n /= 5;
			count += n;
		}
        return count;
    }
	
	public static void main(String[] args){
		System.out.println(trailingZeroes(50));
	}
}
