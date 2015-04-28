package LeetCode;
/**
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 
 * @author xujian
 * Excel Sheet Column Number
 */
public class LeetCode_171 {

	//以26为基数单位，和十进制一样，现在改为26进制就行
	public static int titleToNumber(String s){
		int result = 0;
		int index = 1;
		for(int i = s.length() - 1; i >= 0; i--){
			result += (s.charAt(i) - 'A' + 1) * index;
			index *= 26;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("Z"));
	}

}
