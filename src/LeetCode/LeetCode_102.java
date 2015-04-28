package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author xujian
 * Binary Tree Level Order Traversal 
 */
public class LeetCode_102 {
	
	//DFS
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root == null){
			return results;
		}
		//Stack<TreeNode> stack = new Stack<TreeNode>();
		//显然这里就不能用stack. stack first in last out
		//queue first in first out
		//这里为了保持左右的顺序一样 queue offer/poll
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		List<TreeNode> li = new ArrayList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			list = new ArrayList<Integer>();
			li = new ArrayList<TreeNode>();
			while (!queue.isEmpty()) {
				TreeNode temp = queue.poll();			
				list.add(temp.val);				
				if(temp.left != null){
					li.add(temp.left);
				}
				if(temp.right != null){
					li.add(temp.right);
				}
			}
			results.add(list);
			for(TreeNode t : li){
				queue.offer(t);				
			}
		}
        return results;
    }
	
	//BFS
	public static List<List<Integer>> levelOrder2(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
	}
	
	public static void levelHelper(List<List<Integer>> res, TreeNode root, int height){
		if(root == null){
			return;
		}
		if(height >= res.size()){
			res.add(new LinkedList<Integer>());
		}
		res.get(height).add(root.val);
		levelHelper(res, root.left, height+1);
		levelHelper(res, root.right, height+1);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode r2 = new TreeNode(3);
		TreeNode r3 = new TreeNode(4);
		TreeNode r4 = new TreeNode(5);
		root.left = r1;
		root.right = r2;
		r1.left = r3;
		r2.right = r4;
		List<List<Integer>> results = levelOrder2(root);
		for(List<Integer> l : results){
			System.out.println(l);
		}
	}
}
