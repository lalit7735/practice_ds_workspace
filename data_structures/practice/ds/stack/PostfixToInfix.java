package ds.stack;

import java.util.Stack;

public class PostfixToInfix {

	public static String postFixToInfix(String postfix){
		String infix="";
		Stack<String> stack=new Stack<>();
		for(int i=0;i<postfix.length();i++){
			char c=postfix.charAt(i);
			if(Character.isLetterOrDigit(c)){
				stack.push(c+"");
			}else{
				// it is a operand
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				stack.push("("+operand2+c+operand1+")");
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		System.out.println(PostfixToInfix.postFixToInfix("abc+de/*-"));
	}
}
