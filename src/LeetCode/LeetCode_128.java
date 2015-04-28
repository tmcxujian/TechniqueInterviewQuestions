package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence.
 * @author xujian
 * Longest Consecutive Sequence
 */
public class LeetCode_128 {

	//Use sort() to sort the array, and then go through the array
	public static int longestConsecutive(int[] num){
		Arrays.sort(num);
		int len = 1;
		int i = 0;
		while(i < num.length - 1){
			int temp = 1;
			while(i < num.length - 1 && (num[i] == (num[i+1] - 1) || num[i] == num[i+1])){
				if(num[i] == num[i+1]){
					i++;
				}
				else{
					i++;
					temp++;
				}	
			}
			len = Math.max(temp,len);
			i++;
		}
		return len;
	}
	
	//Use HashMap to implement this one
	public static int longestConsecutive2(int[] num){
		int len = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int x : num){
			if(!map.containsKey(x)){
				int left = map.containsKey(x-1) ? map.get(x-1) : 0;
				int right = map.containsKey(x+1) ? map.get(x+1) : 0;
				int temp = left + right + 1;
				map.put(x, temp);
				len = Math.max(temp,len);
				map.put(x-left, temp);
				map.put(x+right, temp);
			}
			else{
				//deal with duplicates
				continue;
			}
		}
		return len;
	}
	
	//Another way using HashMap
	public int longestConsecutive3(int[] num) {
	    boolean[] visited = new boolean[num.length];
	    HashMap<Integer, Integer> numPos = new HashMap<Integer, Integer>();
	    for(int i = 0; i < num.length; i++){
	        if(!numPos.containsKey(num[i])){
	            numPos.put(num[i], i);
	        }
	    }
	    int maxlen = 0;
	    for(int i = 0; i < num.length; i++){
	        if(visited[i])
	            continue;
	        int len = 1;
	        visited[i] = true;
	        int val = num[i];
	        int curVal = val;
	        while(numPos.containsKey(curVal+1) && !visited[numPos.get(curVal+1)]){
	            visited[numPos.get(val+1)] = true;
	            curVal = curVal + 1;
	            len ++;
	        }
	        curVal = val;
	        while(numPos.containsKey(curVal-1) && !visited[numPos.get(curVal -1)]){
	            visited[numPos.get(curVal -1)] = true;
	            curVal = curVal -1;
	            len ++;
	        }
	        if(len > maxlen){
	            maxlen = len;
	        }
	    }
	    return maxlen;
	}
	
	public static void main(String[] args) {
		int[] A = {100,4,200,1,3,2};
		int[] B = {1,2,0,1};
		System.out.println(longestConsecutive2(A));
		System.out.println(longestConsecutive2(B));
	}

}
