package AlgorithmOnlineCourse;

public class Stack_Array {
	//defect of this when N exceeds capacity, stack overflows
	//resizing array Implementation
	private String[] s;
	private int index = 0;
	
	public Stack_Array(int capacity){
		s = new String[capacity];
	}
	
	//loitering: holding a reference to an object when it is no longer needed
	//garbage collector could reclaim the memory only if there is no outstanding references
	//Also need to consider about when stack is empty and tries to pop()
	public String pop(){
		String item = s[--index];
		s[index] = null;
		//shrink array
		if(index > 0 && index == s.length / 4){
			resize(s.length / 2);
		}
		return item;
	}
	
	public void push(String str){
		//deal with overflow
		if(index == s.length){
			resize(2 * s.length);
		}
		s[index++] = str;
	}
	
	public boolean isEmpty(){
		return index == 0;
	}
	
	///Resizing Array: repeated doubling 
	//if the array is full, then create a new array of twice the size and copy items
	private void resize(int capacity){
		String[] copy = new String[capacity];
		for(int i = 0; i < s.length; i++){
			copy[i] = s[i];
		}
		s = copy;
	}
}
