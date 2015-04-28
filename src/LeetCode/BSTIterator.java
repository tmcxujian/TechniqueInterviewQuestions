package LeetCode;

import java.util.Stack;

/**
 * 
 * @author xujian
 * Binary Search Tree Iterator
 */
public class BSTIterator {

	static Stack<TreeNode> stack;
	
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if(root != null){
        		constructBST(root);
        }
    }

    public static void constructBST(TreeNode root){
    	//注意stack特性，反向存数值
    		if(root.right != null){
    			constructBST(root.right);
    		}
    		stack.push(root);
    		if(root.left != null){
    			constructBST(root.left);
    		}
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop().val;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
