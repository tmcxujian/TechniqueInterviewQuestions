package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Depth of Binary Tree
 * @author xujian
 *
 */
public class LeetCode_111 {

	public static int minDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		int depth = 0;
		//for this case, pay attention to this special case.
		if(leftDepth * rightDepth == 0){
			depth = leftDepth == 0 ? rightDepth :leftDepth;
		}
		else{
			depth = Math.min(leftDepth, rightDepth);
		}
		return depth + 1;
	}
	
	public static int minDepthII(TreeNode root){
		if(root == null){
			return 0;
		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		return levelOfOrder(list,0);
	}
	
	public static int levelOfOrder(List<TreeNode> list, int count){
		count++;
		List<TreeNode> newlist = new ArrayList<TreeNode>();
		for(TreeNode x : list){
			if(x.left == null && x.right == null){
				return count;
			}
			if(x.left != null){
				newlist.add(x.left);
			}
			if(x.right != null){
				newlist.add(x.right);
			}
		}
		return levelOfOrder(newlist, count);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		root.left = t1;
		root.right = t2;
		//root.right = new TreeNode(3);
		//root.right.right = new TreeNode(4);
		//root.left = new TreeNode(1);
		//root.left.left = new TreeNode(2);
		System.out.println(minDepthII(root));
	}

}
