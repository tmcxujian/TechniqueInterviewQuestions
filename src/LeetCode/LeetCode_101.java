package LeetCode;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * @author xujian
 * Symmetric Tree
 */
public class LeetCode_101 {

	//recursive BFS
	public static boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return BFS(root.left,root.right);
	}
	
	public static boolean BFS(TreeNode left,TreeNode right){
		if(left == null || right == null){
			return left == right;
		}
		if(left.val != right.val){
			return false;
		}
		return BFS(left.left,right.right) && BFS(left.right, right.left);
	}
	
	//below is iteration DFS
	public static boolean isSymmetric2(TreeNode root){
		if(root == null){
			return true;
		}
		if(root.left == null && root.right == null){
			return true;
		}
		Stack<TreeNode> L = new Stack<TreeNode>();
		Stack<TreeNode> R = new Stack<TreeNode>();
		L.push(root.left);
		R.push(root.right);
		while(!L.isEmpty() && !R.isEmpty()){
			TreeNode left = L.pop();
			TreeNode right = R.pop();
			if(left == null && right == null){
				continue;
			}
			else if(left != null && right != null && left.val == right.val){
				L.push(left.left);
				R.push(right.right);
				L.push(left.right);
				R.push(right.left);	
			}
			else{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(isSymmetric2(root));
	}

}
