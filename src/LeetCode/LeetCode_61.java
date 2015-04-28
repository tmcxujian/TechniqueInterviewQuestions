package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author xujian
 * Rotate List
 */

public class LeetCode_61 {
	
	//这个函数最直接，先算长度，在找到N的那个点，断开前面的链接，在连接后面的
	//注意里面的special case. N  >= len
	public static ListNode rotateRight(ListNode head, int n){
		if(head == null || head.next == null || n == 0){
			return head;
		}
		ListNode p = head;
		int len = 0;
		while(p != null){
			len ++;
			p = p.next;
		}
		n = n > len ? n % len : n;
		if(n == len || n == 0){
			//special cases
			return head;
		}
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		p = head;
		while(len > n){
			prev = prev.next;
			p = p.next;
			len--;
		}
		prev.next = null;
		dummyHead.next = p;
		while(p.next != null){
			p = p.next;
		}
		p.next = head;
		return dummyHead.next;
	}
	
	//这个大体上差不多...就是简洁点
	//还有一个可以用快慢指针来做，快指针总是领先满指针N个位置
	public static ListNode rotateRight2(ListNode head, int n){
		if(head == null || head.next == null || n == 0){
			return head;
		}
		ListNode p = head;
		int len = 1;
		while(p.next != null){
			p = p.next;
			len++;
		}
		p.next = head;//form a circle
		n = n % len;
		for(int i = 0; i < len - n; i++){
			p = p.next;
		}
		head = p.next;
		p.next = null;
		return head;
	}
	
	//利用List去存储ListNode，其实和2在算术上差不多
	public static ListNode rotateRight3(ListNode head, int n){
		if (head == null || n == 0) {
			return head;
		}

		List<ListNode> nodes = new ArrayList<ListNode>();
		ListNode curr = head;
		while (curr != null) {
			nodes.add(curr);
			curr = curr.next;
		}

		n = n % nodes.size();
		if (n == 0) {
			return head;
		}
		//精华在这几个.... 
		nodes.get(nodes.size() - 1).next = nodes.get(0);//form a circle
		nodes.get(nodes.size() - 1 - n).next = null;

		return nodes.get(nodes.size() - n);
	}
	
	public static void main(String[] args){
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		
		ListNode q1 = new ListNode(1);
		ListNode q2 = new ListNode(2);
		q1.next = q2;
		ListNode result = rotateRight2(q1, 1);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
