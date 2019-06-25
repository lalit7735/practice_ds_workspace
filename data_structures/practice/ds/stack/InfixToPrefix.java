package ds.stack;

import java.util.Stack;
/*
 * Algorithm used
 */
public class InfixToPrefix {

	public static void main(String[] args) {
		String prefixExp = InfixToPrefix.infixToPrefix("a+b*(c^d-e)^(f+g*h)-i");
		System.out.println(prefixExp);
	}

	public static int getOperandPrecedence(char c){
		switch(c){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
			default :
				return -1;
			
		}
	}
	public static String infixToPrefix(String infix){
		Stack<Character> stack=new Stack<Character>();
		String prefix="";
		char[] charArray = infix.toCharArray();
		for(int i=0;i<charArray.length;i++){
			char c=charArray[i];
			if(Character.isLetterOrDigit(c)){
				prefix+=c;
			}else if(c == '('){
				stack.push(c);
			}else if(c == ')'){
				while(stack.peek()!='('){
					prefix+=stack.pop();
				}
				stack.pop();
			}else{
				// scanned operand is of lower precedence
				while(!stack.isEmpty() && getOperandPrecedence(stack.peek())>= getOperandPrecedence(c)){
					prefix+=stack.pop();
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()){
			prefix+=stack.pop();
		}
		return prefix;
	}
}
