package LeetCode;
/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author xujian
 * Sort List
 */
public class LeetCode_148 {
	
	//用O(n log n)这个时间段的sorting algorithm: quick sort/heap sort/merge sort
	public static ListNode sortList(ListNode head) {
		if(head == null){
			return null;
		}
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}
		if(len == 1){
			return head;
		}
		int middle = (int)Math.floor(len/2);
		ListNode leftHead = head;
		ListNode temp = head;
		for(int i = 1; i < middle; i++){
			temp = temp.next;
		}
		ListNode rightHead = temp.next;
		temp.next = null;
		ListNode left = sortList(leftHead);
		ListNode right = sortList(rightHead);
		ListNode rs = merge(left, right);
		return rs;
	}
	
	public static ListNode merge(ListNode leftHead, ListNode rightHead){
		ListNode dummyHead = new ListNode(-1);
		ListNode curr = dummyHead;
		while(leftHead != null || rightHead != null){
			int lv = leftHead == null ? Integer.MAX_VALUE : leftHead.val;
			int rv = rightHead == null ? Integer.MAX_VALUE : rightHead.val;
			if(lv <= rv){
				curr.next = leftHead;
				leftHead = leftHead.next;
			}
			else{
				curr.next = rightHead;
				rightHead = rightHead.next;
			}
			curr = curr.next;
		}
		return dummyHead.next;
	}
	
	
	public static void main(String[] args){
		ListNode p1 = new ListNode(3);
		ListNode p2 = new ListNode(1);
		ListNode p3 = new ListNode(4);
		p1.next = p3;
		p3.next = p2;
		ListNode p = sortList(p1);
		while(p != null){
			System.out.println(p.val);
			p = p.next;
		}
	}
}
