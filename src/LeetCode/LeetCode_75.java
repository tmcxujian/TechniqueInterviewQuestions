package LeetCode;

import javax.xml.transform.Templates;

/**
 * Sort colors
 * @author xujian
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * One-pass
 */

public class LeetCode_75 {

	//中心思想就类似于快速排序：以1为中间，0在左边，2在右边 
	public static void sortColors(int[] A){
		int prevIndex = -1;
		int postIndex = A.length;
		int i = 0;
		//注意这里的while loop条件
		while(i < postIndex){
			if(A[i] == 0 && i != ++prevIndex){
				swap(A, i, prevIndex);
			}
			else if(A[i] == 2 && i != --postIndex){
				swap(A, i, postIndex);
			}
			else{
				i++;
			}
		}
	}
	
	public static void swap(int[] A, int a, int b){
		int temp = A[a];
		A[a] = A[b];
		A[b]= temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,0,0,2,1,0,1,1,2,1,0};
		int[] B = {2,0};
		sortColors(A);
		sortColors(B);
		//Hello(A);
		//Hello(A);
		for(int x : A){
			System.out.print(x + " ");
		}
		System.out.println();
		for(int x : B){
			System.out.print(x + " ");
		}
	}

}
