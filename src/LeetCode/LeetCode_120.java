package LeetCode;
import java.util.List;

/**
 * Triangle
 * @author xujian
 *
 */
public class LeetCode_120 {
	
	//bottom-up 从最底层开始计算,反过来计算最小路径
	public static int minimumTotal(List<List<Integer>> triangle){
		int[] F = new int[triangle.size()];
		for(int i = 0; i < triangle.size(); i++){
			F[i] = triangle.get(triangle.size()-1).get(i);
		}
		for(int i = triangle.size() - 2; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				F[j] = triangle.get(i).get(j) + Math.min(F[j], F[j+1]);
			}
		}
		return F[0];
	}
	
	/**
	 *  2
	 * 3 4
	 * 作为例子：3，4出发到达2.只保留最小的
	 */
	
}
