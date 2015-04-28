package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * @author xujian
 * Populating Next Right Pointers in Each Node 
 */
public class LeetCode_116 {

	public static void connect(TreeLinkNode root) {
		if(root == null){
			return;
		}
		//Stack<TreeNode> stack = new Stack<TreeNode>();
		//显然这里就不能用stack. stack first in last out
		//queue first in first out
		//这里为了保持左右的顺序一样 queue offer/poll
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		List<TreeLinkNode> li = new ArrayList<TreeLinkNode>();
		queue.offer(root);
		root.next = null;
		while (!queue.isEmpty()) {
			li = new ArrayList<TreeLinkNode>();
			while (!queue.isEmpty()) {
				TreeLinkNode temp = queue.poll();							
				if(temp.left != null){
					li.add(temp.left);
				}
				if(temp.right != null){
					li.add(temp.right);
				}
			}
			for(int i = 0; i < li.size() - 1; i++){
				queue.offer(li.get(i));
				li.get(i).next = li.get(i+1);
			}
			if(li.size() - 1 >= 0){
				li.get(li.size()-1).next = null;
				queue.offer(li.get(li.size()-1));
			}		
		}
	}
}
