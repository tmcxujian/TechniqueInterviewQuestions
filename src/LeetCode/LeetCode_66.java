package LeetCode;

import java.util.List;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * @author xujian
 *
 */
public class LeetCode_66 {
	public void plusOne(List<Integer> digits) {
		for (int i = digits.size() - 1; i > 0; i--){
			int digit = digits.get(i);
			if(digit < 9){
				digits.set(i, digit + 1);
				return;
			}else {
				digits.set(i, 0);
			}
		}
	}
}
