package LeetCode;
/**
 * Length of last word
 * @author xujian
 *
 */
public class LeetCode_58 {

	public static int lengthOfLastWord(String s){
		int i = s.length() - 1;
		int count = 0;
		while(i > -1){
			if(s.charAt(i) == ' ' && count != 0){
				break;
			}
			if(s.charAt(i) != ' '){
				count++;
			}
			i--;
		}
		//System.out.println(i);
		//System.out.println(s.length() - 1);
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a ";
		String s1 = "hello world";
		System.out.println(lengthOfLastWord(s));
		System.out.println(lengthOfLastWord(s1));
	}

}
