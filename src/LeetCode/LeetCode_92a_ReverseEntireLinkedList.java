package LeetCode;

public class LeetCode_92a_ReverseEntireLinkedList {

	public static ListNode head;
	
	public static ListNode reverseEntireLinkedList(ListNode head){
		//base case
		if(head == null || head.next == null){
			return head;
		}	
		ListNode cp = head;
		ListNode prev = null;
		while(cp != null){
			ListNode node = cp.next;
			cp.next = prev;
			prev = cp;
			cp = node;
		}
		head = prev;
		return head;
	}
	
	public static void reverseEntireLinkedList2(ListNode currNode){
		if(currNode == null){
			return;
		}
		if(currNode.next == null){
			head = currNode;
			return;
		}
		reverseEntireLinkedList2(currNode.next);
		currNode.next.next = currNode;
		currNode.next = null;
	}
	
	public static void printList(ListNode head)
	{
	    ListNode temp = head;
	    while(temp != null)
	    {
	        System.out.println(temp.val);    
	        temp = temp.next;  
	    }
	}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		//l1 = reverseEntireLinkedList(l1);
		reverseEntireLinkedList2(l1);
		printList(head);
	}

}
