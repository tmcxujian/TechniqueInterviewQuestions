package Sort;

public class SelectionSort {

	//核心思想是：遍历数组找出最大的那个数，然后插入到合适的正确的位置，这个跟冒泡很像
	public static void selectionSort(int[] A){
		int len = A.length;
		int place = -1;
		for(int j = 0; j < len; j++){
			int max = Integer.MIN_VALUE;
			for(int i = j; i < len; i++){
				if(max < A[i]){
					max = A[i];
					place = i;
				}
			}
			//可以放在前后都可以，视情况而定
			A[place] = A[j];
			A[j] = max;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,6,2,5,4};
		selectionSort(A);
		for(int x : A){
			System.out.println(x);
		}
	}

}
