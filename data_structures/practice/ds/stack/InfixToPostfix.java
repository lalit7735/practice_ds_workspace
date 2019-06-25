package ds.stack;

import java.util.Stack;
/*
 * Algorithm used
 * scan expression from left to right and do the following
 * 1.) if  char is operand then add to expression
 * 2.) if char is '(' push to stack
 * 3.) if char is operator then 
 *   3.1) if operator precedence if more than precedence of operator in stack
 *   or stack contains '(' or stack is empty then push to stack
 *   3.2) else if operator precedence is lower than operator in stack then pop all
 *   element with greater precedence or paranthesis is encountered and add to exp
 *   finally push scanned char to stack
 * 4.) if char is ')' then pop all operator unit encounters '('
 * 5.) repeat above for whole expression
 * 6.) pop all remaining from stack and add to prefix expression 
 */
public class InfixToPostfix {

	public static void main(String[] args) {
		String prefixExp = InfixToPostfix.infixToPrefix("a+b*(c^d-e)^(f+g*h)-i");
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
