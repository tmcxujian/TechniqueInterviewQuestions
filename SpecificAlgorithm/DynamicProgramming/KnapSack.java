package DynamicProgramming;

public class KnapSack {

	public static int KnapSack_Problem(int[] Size, int[] Value, int n){
		int[] F = new int[n+1];
		F[0] = 0;
		for(int i = 1; i <= n; i++){
			int temp = Integer.MIN_VALUE;
			int j = 0;
			while(j < Size.length){
				if(Size[j] <= i){
					temp = Math.max(temp, Value[j]+F[i-Size[j]]);
					temp = Math.max(temp, F[i-1]);
				}
				j++;
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
		int[] Value = {12,1,20,15};
		int[] Capacity = {2,1,3,2};
		System.out.println(KnapSack_Problem(Capacity, Value, 5));
	}

}
