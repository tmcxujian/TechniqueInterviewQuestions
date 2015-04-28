package LeetCode;

import java.util.HashMap;
import java.util.Map;
/**
 * Write a program to find the node at which the intersection of 
 * two singly linked lists begins
 * @author xujian
 * Intersection of Two Linked Lists 
 */
public class LeetCode_160 {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
		while(headA != null){
			map.put(headA,1);
			headA = headA.next;
		}
		while(headB != null){
			if(map.containsKey(headB)){
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}
	
	//两个link list长度不一致，那么肯定是在前面不一致，一旦进入了intersection都应该是一样的
	public static ListNode getIntersectionListNode2(ListNode headA, ListNode headB){
		ListNode pa = headA, pb = headB;
	     while(pa != null && pb != null){
	         pa = pa.next;
	         pb = pb.next;
	     }
	     while(pa != null){
	         headA = headA.next;
	         pa = pa.next;
	     }	    
	     while(pb != null){
	         headB = headB.next;
	         pb = pb.next;
	     }
	     //above is make the start point the same
	     while(headA != null && headA != headB){
	         headA = headA.next;
	         headB = headB.next;
	     }
	     //This is for detecting for intersection
	     return headA;
	}
	
	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p5;
		p3.next = p4;
		p4.next = p5;
		
		ListNode result = getIntersectionNode(p1, p3);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

}
