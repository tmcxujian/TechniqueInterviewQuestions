package CrackCodeInterView;
/**
 * climbing chairs
 * @author xujian
 * similar leetcode 70
 */
public class Chapter9_1 {

	public static int countWays(int n){
		if(n < 0){
			return 0;
		}
		else if(n == 0){
			return 1;
		}		
		return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	
	//dynamic programming
	public static int countWays(int n, int[] map){
		if(n < 0){
			return 0;
		}
		else if(n == 0){
			return 1;
		}
		else if(map[n] > -1){
			return map[n];
		}
		else{
			map[n] = countWays(n-1,map) + countWays(n-2,map) + countWays(n-3,map);
			return map[n];
		}
	}
	
	public static void main(String[] args){
		System.out.println(countWays(4));
	}
	
}
