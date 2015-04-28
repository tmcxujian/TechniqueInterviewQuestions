package DynamicProgramming;

public class Changing_Making {

	//Let F(n) be the minimum number of coins whose values add up to n; 
	//it is convenient to define F (0) = 0. 
	//F(n)= min {F(n−dj)}+1 forn>0, j:n≥dj
	//D[0] should be 1
	public static int Change_Making(int[] D, int n){
		int[] F = new int[D.length];
		F[0] = 0;
		for(int i = 1; i < D.length;i++){
			int min = Integer.MAX_VALUE;
			int j = 0;
			//注意这里的条件，这里每次循环问的其实就是如果要分割的是i，而不是n
			while(j < D.length && D[j] <= i){
				min = Math.min(F[i - D[j]], min);
				j++;
			}
			F[i] = min + 1;
		}
		return F[D.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,4};
		System.out.println(Change_Making(A,6));
	}

}
