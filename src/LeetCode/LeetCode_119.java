package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's triangle II
 * @author xujian
 *
 */
public class LeetCode_119 {
	//can also use the previous 118 one. Just change the index to make it right
	public static List<Integer> generate(int numRows){
		 ArrayList<Integer> res = new ArrayList<Integer>();
		    if(numRows<0)
		        return res;
		    res.add(1);
		    for(int i=1;i<=numRows;i++)
		    {
		        for(int j=res.size()-2;j>=0;j--)
		        {
		            res.set(j+1,res.get(j)+res.get(j+1));
		        }
		        res.add(1);
		    }
		    return res;
	}
	
	public static void main(String[] args){
		System.out.println(generate(3));
	}
}
