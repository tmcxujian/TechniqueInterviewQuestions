package CrackCodeInterView;
/**
 * This one is modifcation of Chapter4_1a version
 * By checking balanced or not during the excuetion. If abs > 1, means not balanced
 * Return -1 and stop
 * @author xujian
 *
 */
public class Chapter4_1b {

	public static int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = getHeight(root.left);
		if(leftHeight == -1){
			return -1;
		}
		
		int rightHeight = getHeight(root.right);
		if(rightHeight == -1){
			return -1;
		}
		
		if(Math.abs(rightHeight - leftHeight) > 1){
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean isBalanced(TreeNode root){
		if(getHeight(root) == -1){//This case deals with root == null this case
			return false;
		}else{
			return true;
		}
	}
	
}
