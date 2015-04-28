package Sort;

public class MergeSort {
	
	private final static int CUTOFF = 7;
	
	//index is so important
	public static boolean less(Comparable x, Comparable y){
		return x.compareTo(y) < 0;
	}
	
	public static void exch(Comparable[] A, int x, int y){
		Comparable swap = A[x];
		A[x] = A[y];
		A[y] = swap;
	}
	
	public static boolean isSorted(Comparable[] a, int start, int end) {
	    for (int i = start; i < end; i++) {
	        if (less(a[i+1],a[i])) {
	            return false;
	        };
	    }
	    return true;
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);
		
		//k <= hi
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k < hi; k++){
			if(i > mid){
				a[k] = aux[j++]; 
			}
			else if(j > hi){
				a[k] = aux[i++];
			}
			else if(less(aux[i],aux[j])){
				a[k] = aux[i++];
			}
			else{
				a[k] = aux[j++];
			}
		}
		
		assert isSorted(a, lo, hi);
	}
	
	//Mergesort has too much overhead for tiny subarrays. 
	//Cutoff to insertion sort for ≈ 7 items.
	public static void mergeSortWithImprovement(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(lo + CUTOFF - 1 >= hi){
			InsertionSort.insertionSort(a,lo,hi);
			return;
		}
		//mid = lo + (hi - lo) /2;
		int mid = lo + (hi - lo) / 2;
		mergeSort(a,aux,lo,mid);
		mergeSort(a,aux,mid+1,hi);
		//already sorted, just stop here
		if(!less(a[mid-1], a[mid])){
			return;
		}
		merge(a, aux, lo, mid, hi);
	}
	
	public static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(lo >= hi){
			return;
		}
		//mid = lo + (hi - lo) /2;
		int mid = lo + (hi - lo) / 2;
		mergeSort(a,aux,lo,mid);
		mergeSort(a,aux,mid+1,hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a){
		int N = a.length;
		Comparable[] aux = new Comparable[a.length];
		mergeSortWithImprovement(a, aux, 0, N-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] a = {1,3,2,4};
		Comparable[] aux = new Comparable[a.length];
		sort(a);
		for(Comparable x : a){
			System.out.println(x);
		}
	}

}
