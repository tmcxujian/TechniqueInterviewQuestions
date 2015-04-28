package LeetCode;

import org.omg.CosNaming.IstringHelper;

/**
 * http://www.careercup.com/question?id=4425679
 * @author xujian
 * Count and Say
 */
public class LeetCode_38 {
	
	//iteration
	public static String countAndSay2(int n){
		if(n < 1){
			return "";
		}
		String prev = "1";
		for(int i = 1; i < n; i++){
			StringBuilder str = new StringBuilder();
			int temp = Character.getNumericValue(prev.charAt(0));
			int count = 1;
			for(int j = 1; j < prev.length(); j++){
				if(Character.getNumericValue(prev.charAt(j)) == temp){
					count++;
				}
				else{
					str.append(count);
					str.append(temp);
					temp = Character.getNumericValue(prev.charAt(j));
					count = 1;
				}
			}
			str.append(count);
			str.append(temp);
			prev = str.toString();
		}
		return prev;
	}
	

	//recursive
	public static String countAndSay(int n){
		if(n == 0){
			return "";
		}
		if(n == 1){
			return "1";
		}
		String s = countAndSay(n-1);
		String say = "";
		int temp = Character.getNumericValue(s.charAt(0));
		int count = 1;
		//注意这里count与for循环中i要保持一致
		for(int i = 1; i < s.length(); i++){
			if(Character.getNumericValue(s.charAt(i)) == temp){
				count++;
			}
			else{
				say = say + count + temp;
				temp = Character.getNumericValue(s.charAt(i));
				count = 1;
			}
		}
		return say + count + temp;
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
		System.out.println(countAndSay2(5));
	}

}
