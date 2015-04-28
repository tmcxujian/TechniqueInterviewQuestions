package LeetCode;

/**
 * @author xujian
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class LeetCode_2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		int flag = 0;
		while(l1 != null || l2 != null){
			int x = (l1 != null) ? l1.val:0;
			int y = (l2 != null) ? l2.val:0;
			int sum = x + y + flag;
			flag = sum / 10;
			p.next = new ListNode(sum % 10);
			p = p.next;
			if(l1 != null){
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}
		if (flag > 0){
			p.next = new ListNode(flag);
		}
		return dummyHead.next;
	}
}
