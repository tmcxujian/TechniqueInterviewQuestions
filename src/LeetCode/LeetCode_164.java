package LeetCode;

import java.util.ArrayList;

/**
 * Maximum Gap
 * @author xujian
 *
 */
public class LeetCode_164 {

	//use bucket sort idea, not how to implement bucket sort algorithm
	//alocate extra N sapce to keep track information
	//http://cgm.cs.mcgill.ca/~godfried/teaching/dm-reading-assignments/Maximum-Gap-Problem.pdf
	public static int maximumGap(int[] num){
		if (num.length <= 1) return 0;
	    if (num.length == 2) return num[0] > num[1] ? (num[0] - num[1]) : (num[1] - num[0]);
	    // array length must be larger than 2
	    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	    for (int i = 0; i < num.length; i++) {
	        if (num[i] > max) max = num[i];
	        if (num[i] < min) min = num[i];
	    }
	    double bucketDelta = ((double)(max - min)) / (num.length - 1);
	    ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
	    for (int i = 0; i < num.length - 1; i++)
	        buckets.add(new ArrayList<Integer>());

	    for (int i = 0; i < num.length; i++) {
	        if (num[i] > min && num[i] < max)
	            buckets.get((int)((num[i] - min) / bucketDelta)).add(num[i]);
	    }
	    int prevMax = min;
	    ArrayList<Integer> buck;
	    int idx;
	    for (idx = 0; idx < num.length - 1; idx++) {
	        buck = buckets.get(idx);
	        if (buck.size() == 0) continue;
	        for (int i : buck)
	            if (i > prevMax) prevMax = i;
	        break;
	    }

	    int currMin = prevMax, currMax = prevMax;   
	    int maxDiff = 0, diff;
	    for (++idx; idx < num.length - 1; idx++) {
	        buck = buckets.get(idx);
	        if (buck.size() == 0) continue;
	        currMax = Integer.MIN_VALUE;
	        currMin = Integer.MAX_VALUE;
	        for (int j : buck) {
	            if (j > currMax) currMax = j;
	            if (j < currMin) currMin = j;  
	        }
	        diff = currMin - prevMax;
	        if (diff > maxDiff) maxDiff = diff;
	        prevMax = currMax;
	    }
	    return maxDiff > (max - prevMax) ? maxDiff : max - prevMax;
	}
	
	
	
}
