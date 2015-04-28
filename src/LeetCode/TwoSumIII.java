package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find. add(input) – Add the number input to an internal
 * data structure. find(value) – Find if there exists any pair of numbers which
 * sum is equal to the value. For example,add(1); add(3); add(5); find(4)􏰀true;
 * find(7)􏰀false
 * 
 * @author xujian
 */

public class TwoSumIII {
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void add(int input) {
		int count = (map.containsKey(input)) ? map.get(input) : 0;
		map.put(input, count + 1);
	}

	public static boolean find(int target) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int y = target - num;
			if (y == num) {
				// For duplicates, ensure there are at least two individual
				// numbers.
				return entry.getValue() >= 2 ? true : false;
			} else if (map.containsKey(y)) {
				return true;
			}
		}
		return false;
		// throw new IllegalArgumentException("Invalid Argument");
	}

	public static void main(String[] args) {
		add(2);
		add(3);
		add(4);
		add(3);
		add(5);
		System.out.println(find(4));
		System.out.println(find(6));
	}
}
