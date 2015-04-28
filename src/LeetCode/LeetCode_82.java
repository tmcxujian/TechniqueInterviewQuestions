package LeetCode;


/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3
 * @author xujian
 * Remove Duplicates from Sorted List II
 */
public class LeetCode_82 {
	
	//if current node is not unique, return deleteDuplicates with head.next. 
	//If current node is unique, link it to result of next list made by recursive call.
	public static ListNode deleteDuplicates2(ListNode head){
		if(head == null){
			return head;
		}
		if(head.next != null && head.val == head.next.val){
			while(head.next != null && head.val == head.next.val){
				head = head.next;
			}
			return deleteDuplicates2(head.next);
		}
		else{
			head.next = deleteDuplicates2(head.next);
		}
		return head;
	}
	
	public static ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode curr = head;
		while(curr != null){
			while(curr.next != null && curr.val == curr.next.val){
				curr = curr.next;
			}
			if(prev.next == curr){
				prev = prev.next;
			}
			else{
				prev.next = curr.next;
			}
			curr = curr.next;
		}
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(3);
		ListNode p5 = new ListNode(4);
		ListNode p6 = new ListNode(4);
		ListNode p7 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		
		ListNode result = deleteDuplicates(p1);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

}
