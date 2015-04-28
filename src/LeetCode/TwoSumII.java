package LeetCode;

/**
 * Similar to Question [1. Two Sum], except that the input array is already
 * sorted in ascending order.
 * 
 * @author xujian
 *
 */

public class TwoSumII {
	public static int[] twoSumII(int[] array, int target) {
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] < target) {
				i++;
			} else if (array[i] + array[j] > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("Invalid argument");
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 7, 9, 14 };
		System.out.println(twoSumII(array, 13).length);
	}
}
