package LeetCode;
/**
 * Partition List
 * @author xujian
 * Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions. For example,
 * Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */

public class LeetCode_86 {

	//思路就是先根据这个x的value把list分割成两个list
	//最后把两个list头尾相连
	public static ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode pl = null;
		ListNode pgr = null;
		ListNode p = head;
		ListNode plHead = null;
		ListNode pgrHead = null;
		while(p != null){
			if(p.val < x){
				if(pl != null){
					pl.next = p;
					pl = pl.next;
				}
				else{
					pl = p;
					plHead = p;
				}
			}
			else{
				if(pgr != null){
					pgr.next = p;
					pgr = pgr.next;
				}
				else{
					pgr = p;
					pgrHead = p;
				}
			}
			p = p.next;
		}
		if(pgr != null){
			pgr.next = null;
		}
		if(plHead != null){
			pl.next = pgrHead;
			return plHead;
		}
		else{
			return pgrHead;
		}
    }

}
