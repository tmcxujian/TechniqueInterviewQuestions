package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return 
 * all possible combinations of k numbers out of 1 ... n.
 * @author xujian
 *
 */
public class LeetCode_77 {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		add(list, n, k);
        return list;
    }
	
	public static void add(List<List<Integer>> list, int n, int k){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
