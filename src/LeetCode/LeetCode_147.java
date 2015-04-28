package LeetCode;
/**
 * Sort a linked list using insertion sort.
 * @author xujian
 *
 */
public class LeetCode_147 {
	
	public static ListNode insertSortList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode curr = head.next;
		ListNode tail = head;
		ListNode helper = null;
		while(curr != null){
			helper = head;
			//insert before head
			if(curr.val <= helper.val){
				tail.next = curr.next;
				curr.next = helper;
				head = curr;
				curr = tail.next;
			}
			//insert after tail
			else if(curr.val >= tail.val){
				tail = tail.next;
				curr = curr.next;
			}
			else{
				while(curr.val > helper.next.val){
					helper = helper.next;
				}
				tail.next = curr.next;
				curr.next = helper.next;
				helper.next = curr;
				curr = tail.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode p1 = new ListNode(3);
		ListNode p2 = new ListNode(1);
		ListNode p3 = new ListNode(5);
		ListNode p4 = new ListNode(2);
		ListNode p5 = new ListNode(7);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		ListNode result = insertSortList(p1);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

}