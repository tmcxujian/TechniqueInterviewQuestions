package LeetCode;

import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical 
 * and the nodes have the same value.
 * @author xujian
 * Same Tree
 */
public class LeetCode_100 {
	
	public static boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null || q == null){
			return q == p;
		}
		if(p.val != q.val){
			return false;
		}
		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}
	
	public static boolean isSameTree2(TreeNode p, TreeNode q){
		if(p == null || q == null){
			return q == p;
		}
		Stack<TreeNode> L = new Stack<TreeNode>();
		Stack<TreeNode> R = new Stack<TreeNode>();
		L.push(p);// p --> left
		R.push(q);// q --> right
		while(!L.isEmpty() && !R.isEmpty()){
			TreeNode left = L.pop();
			TreeNode right = R.pop();
			if(left == null && right == null){
				continue;
			}
			else if(left != null && right != null && left.val == right.val){
				L.push(left.left);
				L.push(left.right);
				R.push(right.left);
				R.push(right.right);
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p = new TreeNode(0);
		p.left = new TreeNode(-5);
		TreeNode q = new TreeNode(0);
		q.left = new TreeNode(-8);
		System.out.println(isSameTree2(p, q));
	}

}
