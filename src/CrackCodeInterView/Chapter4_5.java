package CrackCodeInterView;
/**
 * check if a tree is a binary search tree
 * @author xujian
 * similar leetcode 98
 */
public class Chapter4_5 {

	public static boolean isBinarySearchTree(TreeNode root){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static boolean isBST(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.val > max || root.val < min ){
			return false;
		}
		return isBST(root.left, min, root.val) && 
				isBST(root, root.val, max);
	}
	
	//还有一种办法就是in-order遍历，如下方法:
	public static int index = 0;
	public static void copyBST(TreeNode root, int[] array){
		if(root == null){
			return;
		}
		copyBST(root.left, array);
		array[index] = root.val;
		index++;
		copyBST(root.right, array);
	}
}
