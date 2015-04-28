package CrackCodeInterView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * return linkedlist for each depth of binary search tree
 * @author xujian
 * similar as leetcode 102/107
 */
public class Chapter4_4 {
	
	//这道题完全可以少用一个linkedList，因为leetcode上面需要返回的是int而不是TreeNode
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root){
		ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();
		if(root == null){
			return results;
		}
		LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
		List<TreeNode> te = new ArrayList<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			temp = new LinkedList<TreeNode>();
			te = new ArrayList<TreeNode>();
			while(!queue.isEmpty()){
				TreeNode n = queue.poll();
				temp.add(n);
				if(n.left != null){
					te.add(n.left);
				}
				if(n.left != null){
					te.add(n.left);
				}
				results.add(temp);
				for(TreeNode t : te){
					queue.offer(t);
				}
			}
		}
		return results;
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root){
		ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();
		levelHelper(results,root,0);
		return results;
	}
	
	public static void levelHelper(ArrayList<LinkedList<TreeNode>> results, TreeNode root, int level){
		if(root == null){
			return;
		}
		if(level >= results.size()){
			results.add(new LinkedList<TreeNode>());
		}
		results.get(level).add(root);
		levelHelper(results, root.left, level+1);
		levelHelper(results, root.right, level+1);
	}
}
