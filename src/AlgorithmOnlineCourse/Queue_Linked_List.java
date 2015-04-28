package AlgorithmOnlineCourse;

public class Queue_Linked_List {
	private Node last = null;
	private Node first = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void enqueue(String str){
		Node oldLast = last;
		last = new Node(); 
		last.item = str;
		last.next = null;
		if(isEmpty()){
			first = last;
		}
		oldLast.next = last;
	} 
	
	public String dequeue(){ 
		String item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		return item;
	}
}
