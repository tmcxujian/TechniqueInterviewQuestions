package LeetCode;
/**
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * @author xujian
 * Median of Two Sorted Arrays 
 * This problem should be treated like find K-th smallest number in two sorted arrays
 */

public class LeetCode_4 {
	
	//第一种就是假意合并两个数组,寻找两个有序数组中的第K小的元素
	//每次比较，如果选择的元素已经到了K，就不要再归并下去了...复杂度为O(k)
	//第二种就是不断去掉一部分数组
	public static double findMedianSortedArrays(int A[], int B[]){
		return 0.0;
	}

	
	public static void main(String[] args){
		int[] A = {};
		int[] B = {2,3};
		System.out.println(findMedianSortedArrays(A,B));
	}
}
