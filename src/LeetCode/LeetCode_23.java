package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.xml.soap.Node;
/**
 * Merge k "sorted" linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * @author xujian
 * Merge k Sorted Lists
 */

public class LeetCode_23 {

	//Divide and Conquer using two way merge
	public static ListNode mergeKLists(List<ListNode> lists){
		if(lists.isEmpty()){
			return null;
		}
		int end = lists.size() - 1;
		while(end > 0){	
			int begin = 0;
			while(end > begin){
				lists.set(begin, mergeTwoLists(lists.get(begin), lists.get(end)));
				end--;
				begin++;
			}
		}
		return lists.get(0);
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummyHeader = new ListNode(0);
		ListNode p = dummyHeader;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				p.next = l1;
				l1 = l1.next;
				p = p.next;
			}
			else{
				p.next = l2;
				l2 = l2.next;
				p = p.next;
			}
		}
		if(l1 != null){
			p.next = l1;
		}
		if(l2 != null){
			p.next = l2;
		}
		return dummyHeader.next;
	}
	
	private static final Comparator<ListNode> listComparator = new 
			Comparator<ListNode>(){
		@Override
		public int compare(ListNode x, ListNode y){
			return x.val - y.val;
		}
	};
	
	//using a min heap of size k
	public static ListNode mergeKLists2(List<ListNode> lists) {
		if(lists.isEmpty()){
			return null;
		}
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),listComparator);
		for (ListNode node : lists){
			if(node != null){
				//Inserts the specified element into this priority queue.
				queue.add(node);
			}
		}
		ListNode dummyHeader = new ListNode(0);
		ListNode p = dummyHeader;
		while(!queue.isEmpty()){
			//Retrieves and removes the head of this queue, 
			//or returns null if this queue is empty.
			ListNode n = queue.poll();
			p.next = n;
			p = p.next;
			if(n.next != null){
				queue.add(n.next);
			}
		}
		return dummyHeader.next;
	}

}
