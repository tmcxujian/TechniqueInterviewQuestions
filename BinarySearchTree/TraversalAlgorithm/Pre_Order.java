package TraversalAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import CrackCodeInterView.TreeNode;

public class Pre_Order {
	private static List<Integer> list = new ArrayList<Integer>();

	public static List<Integer> pre_OrderBFS(TreeNode root){
		if(root == null){
			return list;
		}
		list.add(root.val);
		pre_OrderBFS(root.left);
		pre_OrderBFS(root.right);
		return list;
	}
	
	public static List<Integer> pre_OrderDFS(TreeNode root){
		Stack<Integer> stack = new Stack<Integer>();
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
