package LeetCode;

/**
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 最主要要能想到先把array sort
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_15 {

	//Use HashMap to implement
	public static List<List<Integer>> threeSum1(int[] num){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		HashMap<Integer,int[]> map = new HashMap<Integer, int[]>();
		if(num.length < 3){
			return results;
		}
		Arrays.sort(num);
		//因为要用到num[i]与num[i++]比较
		for(int i = 0; i < num.length - 2; i++){
			if(num[i] > 0){//大于0后面就没有比较的必要了
				break;
			}
			map.clear();
			if(i == 0 || num[i] > num[i-1]){
				for(int j = i+1; j < num.length;j++){
					if(map.containsKey(num[j])){
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(map.get(num[j])[0]);
						result.add(map.get(num[j])[1]);
						result.add(num[j]);
						results.add(result);
						while(j < num.length - 1 && num[j] == num[j+1]){
							j++;
						}
					}
					else{
						int[] temp = new int[2];
						temp[0] = num[i];
						temp[1] = num[j];
						map.put((0-num[i]-num[j]),temp);
					}
				}
			}
		}
		
		return results;
	}
	
	//Do not use HashMap to implement
	public static List<List<Integer>> threeSum2(int[] num){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(num.length < 3){
			return results;
		}
		Arrays.sort(num);
		int a = 0;
		int b = 1;
		int c = num.length - 1;
		int sum = 0;
		while (a < num.length - 2){
			//类似这样的都是在remove duplicates
			if(a > 0 && num[a] == num[a - 1]){
				a++;
				continue;
			}
			b = a + 1;
			c = num.length - 1;
			while (b < c){
				if (b > a + 1 && num[b] == num[b-1]){
					b++;
					continue;
				}
				if (c < num.length - 1 && num[c] == num[c+1]){
					c--;
					continue;
				}
				sum = num[a] + num[b] + num[c];
				if(sum > 0){
					c--;
				}
				else if(sum < 0){
					b++;
				}
				else{
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[a]);
					result.add(num[b]);
					result.add(num[c]);
					results.add(result);
					b++;
					c--;
				}
			}
			a++;
		}
		return results;
	}
	
	//This one does not need hashmap either, but does not to delete duplicate items
	public static List<List<Integer>> threeSum23(int[] num){
		int a, b, c;
		List<List<Integer>> result = new ArrayList();
		Arrays.sort(num);

		for (int i = 0; i <= num.length - 3; i++) {
			a = num[i];
			//二分法，从头和尾一起向中间逼近
			for (int j = i + 1, k = num.length - 1; j < k;) {
				b = num[j];
				c = num[k];
				//if-else 和前面一样的道理
				if (b + c == -1 * a) {
					List list = new ArrayList<Integer>();
					list.add(a);
					list.add(b);
					list.add(c);
					result.add(list);
					j++;
					k--;
				} else if (b + c < -1 * a) {
					j++;
				} else {
					k--;
				}
			}
		}

		// remove duplicated items.
		for (int i = result.size() - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (result.get(i).get(0) == result.get(j).get(0)
						&& result.get(i).get(1) == result.get(j).get(1)
						&& result.get(i).get(2) == result.get(j).get(2)) {
					result.remove(j);
					i--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] S = {0,0,0};
		System.out.println(threeSum2(S));
	}

}
