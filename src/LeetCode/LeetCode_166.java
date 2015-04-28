package LeetCode;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.Map;

/**
 * Fraction to Recurring Decimal
 * @author xujian
 *
 */
public class LeetCode_166 {

	public static String fractionToDecimal(int numerator, int denominator){
		//numerator是被除数
		//denominator是除数
		if (numerator == 0) {
            return "0";
        }
		StringBuilder str = new StringBuilder();
		str.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		str.append(num / den);
		num = num % den;
		if(num == 0){
			return str.toString();
		}
		str.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, str.length());
		while(num != 0){
			num = num * 10;
			str.append(num / den);
			num = num % den;
			if(map.containsKey(num)){
				int index = map.get(num);
				str.insert(index, "(");
				str.append(")");
				break;
			}
			else{
				map.put(num,str.length());
			}
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		int x = 1;
		int y = 7;
		System.out.println(fractionToDecimal(x, y));
	}

}
