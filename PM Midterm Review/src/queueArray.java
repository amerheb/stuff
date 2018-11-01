
public class queueArray {

	int capacity;
	int[] data;
	int front; //fist element
	int back; //where next element in queue will go
	
	public queueArray() {
		capacity = 10;
		data = new int[capacity];
		front = 0;
		back = 0;
	}
	
	public void enqueue(int input) {
		if(back >= capacity) {
			capacity *= 2;
			int[] temp = new int[capacity];
			
			for(int i = front; i < back; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
		
		data[back++] = input;
	}
	
	public int dequeue() {
		if((back - front) < capacity / 4) {
			capacity /= 2;
			int[] temp = new int[capacity];
			
			for(int i = 0; i < (back-front); i++) {
				temp[i] = data[i+front];
			}
			
			back = back - front;
			front = 0;
			data = temp;
		}
		
		int output = data[front++];
		data[front - 1] = 0;
		return output;
	}
	
	public void print() {
		System.out.print("[ ");
		for (int i = front; i < back; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("]");
	}
}
