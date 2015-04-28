package LeetCode;

import java.util.Stack;

/**
 * Path Sum
 * @author xujian
 *
 */
public class LeetCode_112 {

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		if(root.val == sum && root.left == null && root.right == null){
			return true;
		}
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
	
	public static boolean hasPathSumII(TreeNode root,int sum){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty() && root != null){
			TreeNode cur = stack.pop();
			if(cur.left == null && cur.right == null){
				//只是一种可能..
				if(cur.val == sum){
					return true;
				}
			}
			if(cur.right != null){
				cur.right.val = cur.val + cur.right.val;
				stack.push(cur.right);
			}
			if(cur.left != null){
				cur.left.val = cur.val + cur.left.val;
				stack.push(cur.left);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		
		TreeNode t = new TreeNode(1);
		TreeNode tt = new TreeNode(2);
		t.left = tt;
		
		System.out.println(hasPathSum(root,1));
		System.out.println(hasPathSum(t,1));
	}

}
