package LeetCode;
/**
 * Excel Sheet Column Title
 * @author xujian
 *
 */
public class LeetCode_168 {
	
	public static String convertToTitle(int n) {
		StringBuilder str = new StringBuilder();
		while(n > 0){
			int temp = n % 26;
			n /= 26;
			if(temp == 0){
				str.insert(0,"Z");
				n--;
			}
			else{
				str.insert(0,(char)('A'+temp-1));
			}			
		}
        return str.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(2));
	}

}
