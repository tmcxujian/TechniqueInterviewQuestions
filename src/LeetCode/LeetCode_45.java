package LeetCode;

import java.util.Arrays;

/**
 * Jump Game II
 * 
 * @author xujian
 *
 */
public class LeetCode_45 {
	//从最后一个开始，找到第一个能到最后的，再往前找第一个能到新的位置的，直到第0位
	public int jump(int[] A) {
		int i = A.length - 1;
		int step = 0;
		while (i > 0) {
			for (int j = 0; j < i; j++) {
				if (A[j] + j >= i) {
					step++;
					i = j;
					break;
				}
			}
		}
		return step;
	}

	public int jump2(int[] A) {
		int canArrive = 0, res = 0, lastCanArrive = 0;
        for(int i = 0;  i < A.length; i++)
        {
            if(i > lastCanArrive)
            {
                res++;
                lastCanArrive = canArrive;
            }
            if(i + A[i] > canArrive)
                canArrive = i + A[i];
        }
        return res;
	}
	
	//Use DP, but will result in time limit
	public int jump3(int[] A){
		int[] min = new int[A.length];
		Arrays.fill(min, Integer.MAX_VALUE);
		min[0] = 0;
		for(int i = 0; i < A.length; i++){
			int temp = Math.min(i + A[i], A.length - 1);
			for(int j = i + 1; j <= temp; j++){
				if(min[j] > min[i] + 1){
					min[j] = min[i] + 1;
				}
			}
		}
		return min[A.length - 1];
	}
}
