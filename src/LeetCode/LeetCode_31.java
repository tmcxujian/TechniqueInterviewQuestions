package LeetCode;

import java.util.Arrays;

import javax.naming.ldap.SortControl;

/**
 * Next permutation
 * @author xujian
 * Here are some examples. Inputs are in the left-hand column and 
 * its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class LeetCode_31 {
	
	//这里要想得到用sort函数来帮助自己
	//这个是找到前一个比后一个小的位置，然后把那边开始排序，然后搜索这里面比之前一个element大一点的数
	public static void nextPermutation(int[] num){
		for(int i = num.length - 1; i > 0; i--){
			if(num[i] > num[i-1]){
				Arrays.sort(num,i,num.length);
				for(int j = i; j < num.length; j++){
					if(num[j] > num[i-1]){
						switchNumber(num, j, i-1);
						break;
					}
				}
			printNumber(num);
			return;
			}
		}
		printNumber(num);
		Arrays.sort(num);
	}
	
	public static void nextPermutations(int[] num){
		for(int i = num.length - 2; i > -1; i--){
			if(num[i] < num[i+1]){
				//经过这个if，i后面的都已经排好序了其实
				int pos = 0;
				for(int j = num.length - 1; j > i;j--){
					if(num[j] > num[i]){
						pos = j;
						break;
					}
				}
				switchNumber(num, i, pos);
				Arrays.sort(num,i+1,num.length);
				return;
			}
		}
		Arrays.sort(num);
	}

	//注意switch两个数没任何response作用
	public static void switchNumber(int[] A,int x, int y){
		A[x] = A[x] + A[y];
		A[y] = A[x] - A[y];
		A[x] = A[x] - A[y];
	}
	
	public static void printNumber(int[] A){
		for(int x : A){
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,1};
		int[] B = {1,3,2};
		//nextPermutation(A);
		nextPermutation(B);
	}

}
