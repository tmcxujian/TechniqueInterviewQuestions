package Sort;

public class ShellSort {

	public static void shellSort(Comparable[] A){
		int N = A.length;
		int h = 1;
		while(h < N / 3){
			h = h * 3 + 1;
		}
		while(h >= 1){
			for(int i = h; i < N; i++){
				for(int j = i; j >= h && less(A[j], A[j-h]); j -= h){
					exch(A , j, j-h);
				}
			}
			h = h / 3;
		}
	}
	
	public static boolean less(Comparable x, Comparable y){
		return x.compareTo(y) < 0;
	}
	
	public static void exch(Comparable[] A, int x, int y){
		Comparable swap = A[x];
		A[x] = A[y];
		A[y] = swap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] A = {8,3,5,1,6,9,7};
		shellSort(A);
		for(Comparable x : A){
			System.out.println(x);
		}
	}

}
