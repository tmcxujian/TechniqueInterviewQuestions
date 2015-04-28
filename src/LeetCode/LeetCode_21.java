package LeetCode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author xujian
 * Merge Two Sorted Lists 
 */
public class LeetCode_21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHeader = new ListNode(0);
        ListNode p = dummyHeader;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
            else{
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return dummyHeader.next;
	}
}
