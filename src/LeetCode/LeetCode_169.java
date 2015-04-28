package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author xujian
 * Majority Element 
 */
public class LeetCode_169 {

	//因为要求说了会超过N/2. 所以还有一种方法就是排序，排序结束了返回的是中间的那个数
	public static int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
        		if(map.containsKey(num[i])){
        			int temp = map.get(num[i]);
        			map.put(num[i], ++temp);
        			if(temp > num.length / 2){
        				return num[i];
        			}
        		}
        		else{
        			map.put(num[i], 1);
        		}
        }
        return num[num.length-1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {6,6,6,7,7};
		int[] B = {8,8,7,7,7};
		System.out.println(A.length / 2);
		System.out.println(majorityElement(A));
		System.out.println(majorityElement(B));
	}

}
