package Sort;
/**
 * insert sort has two types:
 * Shell sort and insertion sort
 * @author xujian
 *
 */
public class InsertionSort {
	
	//index is so important
	public static boolean less(Comparable x, Comparable y){
		return x.compareTo(y) < 0;
	}
		
	public static void exch(Comparable[] A, int x, int y){
		Comparable swap = A[x];
		A[x] = A[y];
		A[y] = swap;
	}
	
	//将一个数插入到一个有序表中，形成一个新的有序表
	public static void insertionSort(int[] A){
		for(int i = 1; i < A.length; i++){
			int j = i - 1;
			int temp = A[i];
			while(j >= 0 && temp < A[j]){
					A[j+1] = A[j];
					j--;
			}
			A[++j] = temp;
		}
	}
	
	public static void insertionSort(Comparable[] A, int start, int end){
		for(int i = start; i < end; i++){
			int j = i - 1;
			Comparable temp = A[i];
			while(j >= 0 && less(temp,A[j])){
					A[j+1] = A[j];
					j--;
			}
			A[++j] = temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,1,5,7,2,4,9,6};
		insertionSort(A);
		for(int x : A){
			System.out.println(x);
		}
	}

}
