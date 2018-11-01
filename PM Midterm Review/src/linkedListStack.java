
public class linkedListStack {

	Node head;
	
	private class Node{		
		int val;
		Node next;
	}
	
	public linkedListStack(){
		head = new Node();
		head.val = 0;
		head.next = null;
	}
	
	public void push(int input) {
		if(head.next == null && head.val == 0) {
			head.val = input;
		}
		
		else {
			Node oldhead = head;
			head = new Node();
			head.val = input;
			head.next = oldhead;
		}
	}
	
	public int pop() {
		if(head.next==null && head.val == 0) {
			System.out.println("Empty List!");
			return 0;
		}
		else if(head.next == null && head.val != 0 ) {
			int output = head.val;
			head.val = 0;
			System.out.println("List now empty.");
			return output;
		}
		else {
			int output = head.val;
			head = head.next;
			return output;
		}

	}
	
	public void print() {
		Node index = head;
		
		while(index.next != null) {
			System.out.print(index.val + " ");
			index = index.next;
		}
		
		System.out.println();
	}
}
