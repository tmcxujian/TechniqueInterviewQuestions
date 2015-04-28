package LeetCode;
/**
 * Given a sorted linked list, delete all duplicates such that each element 
 * appear only once. For example, Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author xujian
 * Remove Duplicates from Sorted List
 */
public class LeetCode_83 {
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if (p == null || p.next == null){
            return p;
        }
        int temp = p.val;
        while(p.next != null){
            if(p.next.val == temp){
                p.next = p.next.next;
            }
            else{
                temp = p.next.val;
                p = p.next;
            }
        }
        return head;
    }
}
