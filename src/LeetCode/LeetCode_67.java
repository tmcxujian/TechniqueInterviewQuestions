package LeetCode;
/**
 * a ="11" b = "1" return "100"
 * @author xujian
 * Add Binary
 */
public class LeetCode_67 {

	public static String addBinary(String a, String b){
		if(a == null || a.length() == 0){
			return b;
		}
		if(b == null || b.length() == 0){
			return a;
		}
		StringBuilder str = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int flag = 0;
		while(i >= 0 && j >= 0){
			int va = Character.getNumericValue(a.charAt(i));
			int vb = Character.getNumericValue(b.charAt(j));
			int sum = (va + vb + flag) % 2;
			flag = (va + vb + flag) / 2;
			str.append(sum);
			i--;
			j--;
		}
		while(i >= 0){
			int sum = (Character.getNumericValue(a.charAt(i)) + flag) % 2;
			flag = (Character.getNumericValue(a.charAt(i)) + flag) / 2;
			str.append(sum);
			i--;
		}
		while(j >= 0){
			int sum = (Character.getNumericValue(b.charAt(j)) + flag) % 2;
			flag = (Character.getNumericValue(b.charAt(j)) + flag) / 2;
			str.append(sum);
			j--;
		}
		if(flag > 0){
			str.append(flag);
		}	
		//This reverse could be implemented using StringBuilder.insert() functions
		//insert(place,string)
		return str.reverse().toString();
	}
	
	//This is a very concise way to organize code, similar to what clean code does
	public String addBinary2(String a, String b) {
		if (a == null || a.isEmpty()) {
			return b;
		}
		if (b == null || b.isEmpty()) {
			return a;
		}
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		StringBuilder stb = new StringBuilder();

		int i = aArray.length - 1;
		int j = bArray.length - 1;
		int aByte;
		int bByte;
		int carry = 0;
		int result;
		//carry == 1 精华啊
		while (i > -1 || j > -1 || carry == 1) {
			aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
			bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
			result = aByte ^ bByte ^ carry;
			carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
			stb.append(result);
		}
		return stb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

}
