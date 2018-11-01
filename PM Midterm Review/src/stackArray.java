import java.util.Random;

public class stackArray {

	
	
	int[] data;
	int capacity;
	int head;
	
	public stackArray() {
		capacity = 10;
		data = new int[capacity]; 
		head = 0;	
	}
	
	public void push(int input) {
		if(head >= capacity) {
			capacity = capacity * 2;
			int[] temp = new int[capacity];
			
			for(int i = 0; i < head; i++) {
				temp[i] = data[i];
			}
			
			data = temp;
		}
		
		data[head++] = input;
	}
	
	public int pop() {
		
		if(head <= capacity/4) {
			capacity = capacity / 2;
			
			int[] temp = new int[capacity];
			
			for(int i = 0; i <= head; i++) {
				temp[i] = data[i];
			}
			
			data = temp;
			
		}
		
		int output = data[--head];
		data[head + 1] = 0;
		
		System.out.println("Removing: " + output);
		
		return output;
	}
	
	
	public void selectionSort() { // O(N^2) worst and best
		
		for(int i = 0; i < head; i++) {
			int min = data[i];
			int location = i;
			for(int j = i; j < head; j++) {
				if (data[j] < min) {
					min = data[j];
					location = j;
				}
			}
			int temp = data[i];
			data[i] = min;
			data[location] = temp;
		}
		
	}
	
	public void insertionSort() { // O(N) best, O(N^2) worst 
		for(int i = 1; i < head; i++) {
			for(int j = i; j > 0; j--) {
					if(data[j] < data[j-1]) {
						int temp = data[j];
						data[j] = data[j-1];
						data[j-1] = temp;
					}
					else break;
			}					
		}		
	}

	public void mergeSort() { // O(log(N)) best and worst
		int[] aux = new int[head];
		for(int i = 0; i < head; i++) {
			aux[i] = data[i];
		}
		sort(aux, 0, head-1);
		
	}
	
	private void sort(int[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sort(aux, lo, mid);
		sort(aux,mid+1,hi);
		merge(aux, lo, mid, hi);
	}
	
	private void merge(int[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		
		for(int k = lo; k <= hi; k++) {
			if (i > mid) data[k] = aux[j++];
			else if (j > hi) data[k] = aux[i++];
			else if (aux[j] < aux[i]) data[k] = aux[j++];
			else data[k] = aux[i++];
		}
		
	}
	
	public void quickSort() { // Best: O(NlogN), Worst: O(N^2)
		shuffle();
		qs(0, head-1);
		
	}
	
	private void qs(int lo, int hi) {
		
		if (hi <= lo) return;
		int j = partition(lo, hi);
		
		qs(lo, j-1);
		qs(j+1, hi);
		
			
	}
	
	private int partition(int lo,int hi) {
		int i = lo, j = hi+1;
		
		while(true) {
			while(data[++i] < data[lo]) {
				if(i == hi) break;
			}
			
			while(data[--j] > data[lo]) {
				if(j==lo) break;
			}
			
			if (i >= j) break;
			
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
		
		int temp = data[j];
		data[j] = data[lo];
		data[lo] = temp;
		
		return j;
	}
	
	private void shuffle() {
		Random rand = new Random();
		int temp = 0;
		
		for(int i = 0; i < head; i++) {
			int num = rand.nextInt(head-i);
			temp = data[i];
			data[i] = data[num];
			data[num] = temp;
		}
	}
	
	
	public void print() {
		System.out.println("Max capacity: " + capacity);
		System.out.print("[ ");
		for(int i = 0; i < head; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("]");
	}
	
}
