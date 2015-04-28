package LeetCode;
/**
 * Implement power(x,n)
 * @author xujian
 *
 */
public class LeetCode_50 {
	//3*3*3
	public static double pow(double x, int n) {
		if(n < 0){
			if(n == -2147483648){
				return 1 / (x * pow(x, -n - 1));
			}
			double result = 1 / pow(x, -n);
			return result;
		}
		else{
			if(n == 1){
				return x;
			}
			else if(n == 0){
				return 1;
			}
			else if(n % 2 != 0){
				return x * pow(x*x, n/2);
			}
			else{
				return pow(x*x, n/2);
			}
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2.0, 7));
	}

}
