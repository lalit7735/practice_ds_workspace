package ds.stack;

public class StackAsLinkedList{
	Node top;
	//SpecialStack minStack=new SpecialStack();
	static class Node{
		int data;
		Node next;
	}
	
	public void push(int data){
		Node node =new Node();
		node.data=data;
		if(top!=null){
			Node temp=top;
			top=node;
			top.next=temp;
		}else{
			top=node;
		}
		//pushMin();
	}
	
	/*private void pushMin() {
		if(minStack.peek()!=null && minStack.peek().data > top.data){
			minStack.push(top.data);
		}else if(minStack.peek() == null){
			minStack.push(top.data);
		}
	}*/

	public int pop(){
		if(top!=null){
			Node tmp=top;
			top=top.next;
			//removeMin(tmp);
			return tmp.data;
		}else{
			return 0;
		}
	}
	
	/*private void removeMin(Node removed) {
		if(removed.data == minStack.peek().data){
			minStack.pop();
		}
	}*/

	public Node peek(){
		return top;
	}
	
	/*public Node getMin(){
		Node peek = minStack.peek();
		minStack.pop();
		return peek;
	}*/
}
