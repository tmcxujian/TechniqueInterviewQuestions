package CrackCodeInterView;
/**
 * Creating a binary search tree with minimum height using a sorted array
 * @author xujian
 * 
 */
public class Chapter4_3 {
	
	public static TreeNode createMinimalBST(int[] array){
		return MinimalBST(array, 0, array.length - 1);
	}
	
	public static TreeNode MinimalBST(int[] array, int start, int end){
		if(start > end){
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(array[mid]);
		n.left = MinimalBST(array, start, mid - 1);
		n.right = MinimalBST(array, mid + 1, end);
		return n;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = createMinimalBST(array);
		System.out.println("Root? " + root.val);
		
	}
}
