package CrackCodeInterView;
/**
 * merge two sorted arrays. A is big enough to hold two arrays
 * @author xujian
 *
 */
public class Chapter11_1 {
	public static void merge(int[] A, int[] B, int lastA, int lastB){
		int total = lastA + lastB - 1;
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		while(indexA >= 0 && indexB >= 0){
			if(A[indexA] > B[indexB]){
				A[total] = A[indexA];
				total--;
				indexA--;
			}
			else{
				A[total] = B[indexB];
				total--;
				indexB--;
			}
		}
		while(indexB >= 0){
			A[total] = B[indexB];
			total--;
			indexB--;
		}
	}
}
