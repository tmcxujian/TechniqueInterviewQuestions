package LeetCode;
/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 * @author xujian
 * Linked List Cycle
 */
public class LeetCode_141 {
	
	public static boolean hasCycle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		if(head == null){
			return false;
		}
		if(head.next == null){
			return false;
		}
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow){
				return true;
			}
		}
		return false;
	}
}
