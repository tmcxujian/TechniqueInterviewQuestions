package LeetCode;
/**
 * Divide two integers without using multiplication or division
 * @author xujian
 *
 */
public class LeetCode_29 {

	//return value is int, not a long or float
	public static int divide(int dividend, int divisor) {
		if(divisor == 0){
			return 0;
		}
		boolean flag = dividend > 0 ^ divisor > 0 ? false : true;
		long dend = Math.abs((long) dividend);
		long dsor = Math.abs((long) divisor);
		long result = divideLongNumber(dend, dsor);
		result = flag ? result : -1 * result;
		return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
	
	//recursion starts
	public static long divideLongNumber(long dividend, long divisor){
	    // Return if nothing to divide
	    if (dividend < divisor) return 0;

	    // Sum divisor 2, 4, 8, 16, 32 .... times
	    // binary search part
	    long sum = divisor;
	    long divide = 1;
	    while ((sum+sum) <= dividend) {
	        sum += sum;
	        divide += divide;
	    }

	    // Make a recursive call for (devided-sum) and add it to the result
	    return (divide + divideLongNumber((dividend-sum), divisor));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
