package LeetCode;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Permutation of String Sequence
 * @author xujian
 *
 */
public class LeetCode_60 {

	//一下就是我的做法，应该是可以做出来的..但是貌似有点小问题
	static class StringComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			// TODO Auto-generated method stub
			System.out.println(s1+"yyy");
			System.out.println(s2+"yyy");
			int x1 = Integer.getInteger(s1);
			int x2 = Integer.getInteger(s2);
			if(x1 > x2){
				return 1;
			}
			else if(x1 == x2){
				return 0;
			}
			else
				return -1;
		}
		
	}
	
	public static String getPermutation(int n, int k) {
		Comparator<String> comparator = new StringComparator();
		List<String> list = new ArrayList<String>();
		getPermutationWithRecursion(n, list);
		System.out.println(list+"g");
		Collections.sort(list, comparator);
		//PriorityQueue<String> queue = new PriorityQueue<String>(list.size()-1,comparator);
		//queue.addAll(list);
		System.out.println(list+"queue");
		//for(int i = 0; i < k; i++){
		//	queue.poll();
		//}
		//return queue.poll();
		return list.get(k);
    }
	
	public static void getPermutationWithRecursion(int n, List<String> list){
		if(n == 1){
			list.add("1");
			return;
		}
		getPermutationWithRecursion(n-1, list);
		List<String> res = new ArrayList<String>();
		for(String s : list){
			System.out.println(s+"lll");
			for(int i = 0; i <= s.length(); i++){
				String temp = s.substring(0, i) + String.valueOf(n) + s.substring(i);
				System.out.println(temp+"uuu");
				res.add(temp);
			}
		}
		list.clear();
		list.addAll(res);
		System.out.println(res+"ggg");
		return;
	}
	
	public static void main(String[] args){
		System.out.println(permutationSequence(4, 17));
	}
	
	//below 是一种更加巧妙地方法
	public static String permutationSequence(int n, int k){
		int total = factorial(n);
		String candidate = "123456789".substring(0, n);
		char[] res = new char[n];
		for(int i = 0; i < n; i++)//依次计算排列的每个位
		{
			total /= (n-i);
			int index = (k-1) / total;
			res[i] = candidate.charAt(index);
			candidate = candidate.substring(0, index) + candidate.substring(index+1);
			//candidate.replace(candidate.charAt(index), '1');
			k -= index*total;
		}
		return String.valueOf(res);
	}

	public static char helper(String str, int k) {
		// TODO Auto-generated method stub
		char[] c = str.toCharArray();
		int temp = factorial(str.length()-1);
		int i = (k-1) / temp;
		char ch = c[i];
		c[i] = '1';
		k -= i*temp;
		return ch;
	}
	
	public static int factorial(int n){
		int res = 1;
		for(int i = 2; i <= n; i++){
			res *= i;
		}
		return res;
	}
}
