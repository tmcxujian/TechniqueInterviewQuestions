package LeetCode;

import java.awt.geom.CubicCurve2D;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * @author xujian
 * Reverse Linked List II
 */
public class leetCode_92 {

	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(head == null){
			return head;
		}
		ListNode dummyListNode = new ListNode(0);
		dummyListNode.next = head;
		ListNode mprev = dummyListNode;
		ListNode mcurr = head;
		//notice about this index 
		for(int i = 1; i < m; i++){
			mcurr = mcurr.next;
			mprev = mprev.next;
		}
		ListNode mbackup = mcurr;
		ListNode mafter = mcurr.next;
		for(int i = 1; i <= (n-m); i++){
			ListNode node = mcurr;
			mcurr = mafter;
			mafter = mafter.next;
			mcurr.next = node;
		}
		mbackup.next = mafter;
		mprev.next = mcurr;
		return dummyListNode.next;
	}
	
	public static void printList(ListNode head)
	{
	    ListNode temp = head;
	    while(temp != null)
	    {
	        System.out.println(temp.val);    
	        temp = temp.next;  
	    }
	}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = null;
		l1 = reverseBetween(l1, 2, 4);
		printList(l1);
	}

}
