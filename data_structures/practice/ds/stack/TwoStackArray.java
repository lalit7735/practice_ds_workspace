package ds.stack;

/**
 * 
 * @author paras.lalit
 * two instances of this class can be created which will share 
 * same array
 */
public class TwoStackArray {
	
	static int instanceCounter=0;
	static int stackArray[]=new int[20];
	static int top1=-1;
	static int top2=20;
	
	public TwoStackArray() throws InstantiationException{
		if(instanceCounter == 2){
			throw new InstantiationException();
		}
		instanceCounter++;
	}
	
	void push1(int x){
		if(top1 < top2-1){
			stackArray[++top1]=x;
		}else{
			System.err.println("no space left for stack1");
		}
	}
	
	int pop1(){
		return stackArray[top1--];
	}
	
	void push2(int x){
		if(top2 > (top1+1)){
			stackArray[--top2]=x;
		}else{
			System.err.println("no space left for stack2");
		}
	}
	
	int pop2(){
		return stackArray[top2++];
	}
}
