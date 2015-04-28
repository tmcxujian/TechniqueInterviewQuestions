package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.security.auth.x500.X500Principal;

/**
 * Maximun depth of binary tree
 * @author xujian
 *
 */
public class LeetCode_104 {

	public static int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	public static int maxDepthII(TreeNode root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		Stack<TreeNode> L = new Stack<TreeNode>();
		Stack<TreeNode> R = new Stack<TreeNode>();
		L.push(root.left);
		R.push(root.right);
		return 0;
	}
	
	public static int levelOfOrder(List<TreeNode> list, int count){
		count++;
		List<TreeNode> newlist = new ArrayList<TreeNode>();
		for(TreeNode t : list){
			if(t.left != null){
				newlist.add(t.left);
			}
			if(t.right != null){
				newlist.add(t.right);
			}
			if(t.left == null && t.right == null){
				
			}
		}
		return levelOfOrder(newlist, count);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		root.left = t1;
		System.out.println(maxDepth(root));

	}

}
