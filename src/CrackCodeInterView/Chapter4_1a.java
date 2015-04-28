package CrackCodeInterView;
//implement a function to decide if a binary tree is balanced
//similar with LeetCode 110
public class Chapter4_1a {
	
	public static int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1){
			return false;
		}else{
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
}
