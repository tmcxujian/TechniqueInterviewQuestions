package CrackCodeInterView;
/**
 * Implement "next" node in binary search tree
 * @author xujian
 * each node has a link to its parent
 */
public class Chapter4_6 {
	
	public static TreeNode inorderSucc(TreeNode n){
		if(n == null){
			return null;
		}
		if(n.right != null){
			return leftMostChild(n.right);
		}
		else{
			TreeNode q = n;
			TreeNode x = q.parent;
			/// Go up until we're on left instead of right
			while(x != null && x.left != q){
				q = x;
				x = x.parent;
			}
			return x;
		}	
	}
	
	public static TreeNode leftMostChild(TreeNode n){
		if(n == null){
			return null;
		}
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
}
