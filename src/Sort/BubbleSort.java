package Sort;

public class BubbleSort {
	//每一个不断的遍历数组，每次遍历总是把最大的那个数找出来放到数组的尾部。经过n轮遍历之后，就排序完成
	public static void bubbleSort(int[] array){
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j < array.length - i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	//用flag来记录这次是否顺序发生了变化，没有的话那么就可以返回了
	public static void BubbleSortOptimization(int[] array){
		boolean flag = false;
		for(int i = 1; i < array.length; i++){
			flag = true;
			for(int j = 0; j < array.length - i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if(flag){
				break;
			}
		}
	}
	
	
	public static void main(String[] args){
		int[] A = {1,3,6,2,5,4};
		int[] B = {1,3,6,2,5,4};
		bubbleSort(A);
		BubbleSortOptimization(B);
		for(int x : B){
			System.out.println(x);
		}
	}
}
