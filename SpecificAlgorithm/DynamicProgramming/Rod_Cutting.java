package DynamicProgramming;

public class Rod_Cutting {

	public static int Rod_Cutting(int[] p, int n){
		int[] F = new int[n+1];
		F[0] = 0;
		//从1开始
		for(int i = 1; i <= n; i++){
			int temp = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++){
				temp = Math.max(temp, p[j]+F[i-j-1]);
			}
			F[i] = temp;
		}
		for(int x : F){
			System.out.println(x);
		}
		return F[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] P = {1,5,8,9,10};
		System.out.println(Rod_Cutting(P,5));
	}

}
