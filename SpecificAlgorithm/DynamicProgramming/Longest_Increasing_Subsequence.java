package DynamicProgramming;

import java.util.Scanner;

public class Longest_Increasing_Subsequence {

	public static int longestIncreasingSubseqence(int[] A){
		int[] B = new int[A.length];
		int max = 0;
		for(int i = 0; i < A.length; i++){
			for(int j = i - 1; j > -1; j--){
				if(A[j] < A[i]){
					max = Math.max(B[j], max);
				}
			}
			B[i] = max + 1;
			max = 0;
		}
		max = 0;
		for(int i = 0; i < B.length; i++){
			max = Math.max(max, B[i]);
		}
		return max;
	}
	
    public static void main(String[] args) 
    {    
        Scanner scan = new Scanner(System.in);
        System.out.println("Longest Increasing Subsequence Algorithm Test\n");
 
        System.out.println("Enter number of elements");
        int n = scan.nextInt();
        int[] arr = new int[n + 1];
        System.out.println("\nEnter "+ n +" elements");
        for (int i = 1; i <= n; i++)
            arr[i] = scan.nextInt();
 
        int result = longestIncreasingSubseqence(arr);       
 
        /** print result **/ 
 
        System.out.print("\nLongest Increasing Subsequence : " + result);
        System.out.println();
        
        int x[] = { 3, 2, 6, 4, 5, 1 };
    		int y[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
    		System.out.println(longestIncreasingSubseqence(x));
    		System.out.println(longestIncreasingSubseqence(y));
    }
}

