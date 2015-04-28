package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author xujian Largest Number
 */
public class LeetCode_179 {
	
	public static String largestNumber(int[] num) {
		PriorityQueue<String> queue = new PriorityQueue<String>(num.length,
				new Comparator<String>() {
					@Override
					//much cheaper compare idea
					public int compare(String o1, String o2) {
						String s2 = o1 + o2;
						String s1 = o2 + o1;
						return s1.compareTo(s2);
					}
				});
		for (int i = 0; i < num.length; i++) {
			String temp = Integer.toString(num[i]);
			queue.add(temp);
		}
		StringBuilder str = new StringBuilder();
		while (queue.size() != 0) {
			str.append(queue.remove());
		}
		// only need to detect whether the first character is '0'
		// if yes, then the whole String is "0"
		if (str.toString().charAt(0) == '0')
			return "0";

		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, 30, 34, 5, 9 };
		int[] B = { 12, 121 };
		int[] C = { 824,8247, 90 };
		System.out.println(largestNumber(B));
		System.out.println(largestNumber(B));
		System.out.println(largestNumber(C));
	}

}
