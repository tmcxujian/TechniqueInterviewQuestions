package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * permutation II
 * @author xujian
 *
 */
public class LeetCode_47 {

	public List<List<Integer>> permuteUnique(int[] num) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<List<Integer>> results = new ArrayList<List<Integer>>();	
		List<List<Integer>> resultscopy = null;	
		if(num.length == 0){
			return results;
		}
		List<Integer> res = new ArrayList<Integer>();
		res.add(num[0]);
		results.add(res);
		resultscopy = results;
		for(int i = 1; i < num.length; i++){
			results = new ArrayList<List<Integer>>();
			//将这一步上面的list复制一遍，在中间夹缝里添加num[i]
			for(int j = 0; j < resultscopy.size(); j++){
				//这里是<=这样就可以嵌在头和尾
				for(int k = 0; k <= resultscopy.get(j).size();k++){
					res = new ArrayList<Integer>(resultscopy.get(j));
					res.add(k, num[i]);
					if(!set.contains(res)){
						set.add(res);
						results.add(res);
					}					
				}
			}	
			resultscopy = results;
		}
        return results;
    }
	
}
