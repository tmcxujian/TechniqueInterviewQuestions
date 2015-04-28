package LeetCode;

/**
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author xujian
 * Remove Nth Node From End of List 
 */

public class LeetCode_19 {
	public static ListNode removeNthFromEnd(ListNode head, int n){
		//length == 1
		if(head.next == null){
			return null;
		}
		ListNode fakeHead = new ListNode(0);
		ListNode p = head;
		fakeHead.next = head;
		ListNode prev = fakeHead;
		//将P指针移至offset的位置
		while(n > 1){
			p = p.next;
			n--;
		}
		while(p.next != null){
			p = p.next;
			head = head.next;
			prev = prev.next;
		}
		//这里应该是head.next而不是p
		//因为N可能是大于2的数，如果是p那么只有一个node
		prev.next = (p == head) ? null : head.next;
		
		return fakeHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode p1 =  new ListNode(2);
		ListNode p2 =  new ListNode(3);
		ListNode p3 =  new ListNode(4);
		ListNode p4 =  new ListNode(5);
		//head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		ListNode result = removeNthFromEnd(head, 1);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
