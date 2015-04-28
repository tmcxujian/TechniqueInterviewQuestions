package LeetCode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * @author xujian
 * Swap Nodes in Pairs
 */

public class LeetCode_24 {
	
	public static ListNode swapPairs(ListNode head){
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = head;
		ListNode prev = dummyHead;
		//这个while循环涵盖了head.next == null 的可能性
		//如果是null，跳过while循环
		while(p != null && p.next != null){
			ListNode q = p.next;
			ListNode r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummyHead.next;
	}
	
	public static void main(String[] args){
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		ListNode result = swapPairs(p1);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
