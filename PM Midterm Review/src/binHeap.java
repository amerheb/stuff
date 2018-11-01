
public class binHeap {
	
	int[] data;
	int N;
	int capacity;
	
	public binHeap(){
		capacity = 10;
		N = 0;
		data = new int[capacity];
	}
	
	public void insert(int input) {
		data[++N] = input;
		swim(N);
		print();
	}
	
	public int delMax() {
		int output = data[1];
		
		int temp = data[1];
		data[1] = data[N];
		data[N--] = temp;
		
		sink(1);
		print();
		return output;
	}
	
	private void swim(int k) {
		while (k > 1 && data[k] > data[k/2]) {
			int temp = data[k];
			data[k] = data[k/2];
			data[k/2] = temp;
			k = k/2;
		}
		
	}
	
	private void sink(int k) {
		while(2*k <=  N) {
			int j = 2*k;
			
			if(j < N && data[j] < data[j+1]) {
				j++;
			}
			
			if(data[j] > data[k]) {
				break;
			}
			
			int temp = data[k];
			data[k] = data[j];
			data[j] = temp;
			
			k = j;
			
		}
	}
	
	private void print() {
		System.out.print("[ ");
		for (int i = 1; i <= N; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("]");
	}
	
}
