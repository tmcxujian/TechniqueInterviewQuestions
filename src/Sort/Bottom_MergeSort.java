package Sort;

public class Bottom_MergeSort {
	
	public static void sort(Comparable[] a){
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for(int sz = 1; sz < N; sz += sz){
			for(int lo = 0; lo < N-sz; lo += sz){
				MergeSort.merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
}
