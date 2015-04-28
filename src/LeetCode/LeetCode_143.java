package LeetCode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * @author xujian
 * Reorder List
 */

public class LeetCode_143 {
	
	//1) 用快慢指针找到中间节点，将链表分成两部分。
	//2) 对后面一半的链表逆序，这个也是常见的问题了(链表反转)。
	//3) 合并两个链表。
	public static void reorderList(ListNode head){
			if(head == null || head.next == null){
				return;
			}
			ListNode dummyHead = new ListNode(-1);
			dummyHead.next = head;
			ListNode p1 = head;
			ListNode p2 = head;
			//p1 represents the middle of the list
			while(p2.next != null && p2.next.next != null){
				p1 = p1.next;
				p2 = p2.next.next;
			}
			//below is reverse the LinkedList
			ListNode slow = p1.next;
			System.out.println(slow.val + "ggg");
			ListNode cp = slow;
			ListNode pre = null;
			while(cp != null){
				ListNode temp = cp.next;
				cp.next = pre;
				pre = cp;
				cp = temp;
			}
			p1.next = null;
			//Below is merge two list happens
			while(head != null && pre != null){
				ListNode temp = head.next;
				head.next = pre;
				pre = pre.next;
				head.next.next = temp;
				head = temp;
			}
	}

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = null;
		//ListNode head = p1;
		/*while(head != null){
			System.out.println(head.val);
			head= head.next;
		}*/
		reorderList(p1);
		while(p1 != null){
			System.out.println(p1.val);
			p1 = p1.next;
		}
	}

}
