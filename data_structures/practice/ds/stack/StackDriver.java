package ds.stack;

public class StackDriver {

	public static void main(String[] args) throws SizeOverFlowException, InstantiationException {
		stackAsArrayDriver();
		stackAsLinkedListDriver();
		twoStackArrayDriver();
	}

	private static void twoStackArrayDriver() throws InstantiationException {
		System.out.println(" -- twoStackArrayDriver --");
		TwoStackArray stack1=new TwoStackArray();
		TwoStackArray stack2=new TwoStackArray();
		for(int i=1;i<=20;i++){
			stack1.push1(i);
		}
		stack1.pop1();
		stack2.push2(5);
	}

	private static void stackAsLinkedListDriver() {
		System.out.println("-- stack as lined list --");
		StackAsLinkedList stack=new StackAsLinkedList();
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(1);
		//System.out.println("Min data:"+stack.getMin().data);
		System.out.println(" iterating stack ");
		
		while(stack.peek()!=null){
			System.out.println(stack.pop());
		}
		stack.pop();
		//System.out.println("Min data:"+stack.getMin().data);
	}

	private static void stackAsArrayDriver() throws SizeOverFlowException {
		StackAsArray stack=new StackAsArray();
		for(int i=1;i<=10;i++){
			stack.push((i+10));
		}
		System.out.println(" peek data :"+stack.peek());
		for(int i=1;i<=10;i++){
			System.out.println(" pop data :"+stack.pop());
		}
	}
}
