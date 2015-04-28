package LeetCode;
/**
 * 
 * @author xujian
 * sqrt(x)
 */
public class LeetCode_69 {

	public static int sqrt(int x){
		int lo = 1;
		int hi = x;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			int temp = x / mid;
			if(mid == temp){
				return mid;
			}
			else if(mid > temp){
				hi = mid - 1;
			}
			else{
				lo = mid + 1;
			}
		}
		return hi;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(3));
	}

}
