package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {

	public static List<String> findMissingRanges(int[] array, int start, int end) {
		List<String> result = new ArrayList<String>();
		int prev = start - 1;
		for (int i = 0; i <= array.length; i++) {
			int curr = (i == array.length) ? end + 1 : array[i];
			if (curr - prev >= 2) {
				result.add(getRange(prev + 1, curr - 1));
			}
			prev = curr;
		}
		return result;
	}

	public static String getRange(int start, int end) {
		return (start == end) ? String.valueOf(start) : start + "->" + end;
	}

	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 45, 56, 97 };
		System.out.println(findMissingRanges(array, 0, 99));
	}
}
