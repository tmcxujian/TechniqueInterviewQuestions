package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based. You may assume that each input would have exactly one
 * solution.
 * 
 * @author xujian
 *
 */

public class LeetCode_1 {

	public static int[] twoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(target - array[i])) {
				return new int[] { map.get(target - array[i]) + 1, i + 1 };
			}
			map.put(array[i], i);
		}
		throw new IllegalArgumentException("Invalid Argument");
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 7, 9, 14 };
		System.out.println(twoSum(array, 13));
	}
}
