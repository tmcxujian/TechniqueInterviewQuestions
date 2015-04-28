package Sort;

import java.util.Random;

/**
 * 随机排序/洗牌算法
 * Knuth shuffle
 * @author xujian
 *
 */
public class ShuffleSort {
	
	private static Random rand = new Random();
	
	public static boolean less(Comparable x, Comparable y){
		return x.compareTo(y) < 0;
	}
	
	public static void exch(Comparable[] A, int x, int y){
		Comparable swap = A[x];
		A[x] = A[y];
		A[y] = swap;
	}
	
	public static void shuffle(Comparable[] A){
		int N = A.length;
		for(int i = 0; i < N; i++){
			int x = rand.nextInt(i+1);
			exch(A, i, x);
		}
	}
}
