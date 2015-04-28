package CrackCodeInterView;

import java.util.HashSet;

public class Chapter2_1 {

	//use hashtable to keep track of duplicate elements
	public static void deleteDup(LinkedListNode n){
		HashSet<Integer> table = new HashSet<Integer>();
		LinkedListNode dummyHead = n;
		LinkedListNode head = n;
		while(dummyHead != null){
			if(table.contains(dummyHead.data)){
				head.next = dummyHead.next;
			}
			else{
				table.add(dummyHead.data);
				head = dummyHead;
			}
		}
		dummyHead = dummyHead.next;
	}

	public static void main(String[] args) {
		LinkedListNode root = new LinkedListNode(0);
		root.next = new LinkedListNode(1);
		root.next.next = new LinkedListNode(0);
		deleteDup(root);
		while(root!=null){
			System.out.println(root.data);
			root = root.next;
		}
	}

}
