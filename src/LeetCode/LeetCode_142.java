package LeetCode;
/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null
 * @author xujian
 * Linked List Cycle II
 */
public class LeetCode_142 {
	
	public static ListNode detectCycle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		if(head == null){
			return null;
		}
		if(head.next == null){
			return null;
		}
		while(fast.next != null && fast != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				slow = head;
				while(slow != fast){
					slow = slow.next;
					//这时候都是一步一步走
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
