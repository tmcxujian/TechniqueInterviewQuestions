package Sort;
/**
 * 快速排序还有冒泡排序都是交换排序
 * @author xujian
 *
 */
public class QuickSort {

	public static void quickSort(int[] A){
		quick_Sort(A, 0, A.length-1);
	}
	
	public static void quick_Sort(int[] A, int left, int right){
		if(left > right){
			return;
		}
		int l = left;
		int r = right;
		int key = A[left];
		while(l < r){
			while(A[r] >= key && l < r){
				r--;
			}
			while(A[l] <= key && l < r){
				l++;
			}
			swap(A, r, l);
		}
		swap(A, l, left);
		quick_Sort(A, left, l-1);
		quick_Sort(A, r+1, right);
	}
	
	public static void swap(int[] A, int a, int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,1,5,7,2,4,9,6};
		quickSort(A);
		for(int x : A){
			System.out.println(x);
		}
	}

}
