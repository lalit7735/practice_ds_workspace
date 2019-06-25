package ds.stack;

public class StackAsArray {
	private int capacity=10;
	int top=-1;
	int data[]=new int[capacity];
	public StackAsArray() {
	}
	public StackAsArray(int initialCapacity) {
		capacity=initialCapacity;
	}
	
	public void push(int data) throws SizeOverFlowException{
		if(top < capacity){
			this.data[++top]=data;
		}else{
			throw new SizeOverFlowException(" stack is already fulled ");
		}
	}
	
	public int pop(){
		return data[top--];
	}
	
	public int size(){
		return data.length;
	}
	
	public int peek(){
		return data[top];
	}
}
