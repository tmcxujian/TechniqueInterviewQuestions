package AlgorithmOnlineCourse;

public class Stack_Linked_List {
	private Node first = null;
	
	//private inner class
	private class Node{
		String item;
		Node next;
	}
	
	public String pop(){
		String item = first.item;
		first = first.next; 
		return item;
	}
	public void push(String item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
}
