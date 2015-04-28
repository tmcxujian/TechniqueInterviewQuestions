package DynamicProgramming;
/**
 * EXAMPLE 1 Coin-row problem 
 * There is a row of n coins whose values are some positive integers c1, c2, . , cn, 
 * not necessarily distinct. 
 * The goal is to pick up the maximum amount of money subject to 
 * the constraint that no two coins adjacent in the initial row can be picked up.
 * @author xujian
 *
 */
public class Coin_Row {

	//F(n)=max{cn +F(n−2),F(n−1)} forn>1, 
	//F(0) = 0, F(1) = c1.
	public static int coinRow(int[] Coin){
		int[] F = new int[Coin.length];
		//其实只要两个参数就可以搞定不需要一个额外的数组
		F[0] = 0;
		F[1] = Coin[0];
		for(int i = 2; i < Coin.length; i++){
			F[i] = Math.max(F[i-2] + Coin[i], F[i-1]);
		}
		return F[Coin.length-1];
	}
	
	public static void main(String[] args) {
		int[] Coin = {5, 1, 2, 10, 6, 2};
		System.out.println(coinRow(Coin));
	}

}
