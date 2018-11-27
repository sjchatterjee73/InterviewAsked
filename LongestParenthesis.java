/*
	Given a string containing just the characters '(' and ')', 
	find the length of the longest valid (well-formed) parentheses substring.

	Example 1:
	Input: "(()"
	Output: 2
	Explanation: The longest valid parentheses substring is "()"
	
	Example 2:
	Input: ")()())"
	Output: 4
	Explanation: The longest valid parentheses substring is "()()"
*/
import java.util.*;

class Stack{
	char [] stack;
	int top;
	public Stack(int size){
		stack = new char[size];
		top = -1;
	}
	
	char pop(){
		return stack[top--];
	}
	char peek(){
		return stack[top];
	}
	void push(char c){
		stack[++top] = c;
	}
	boolean isEmpty(){
		return (top == -1);
	}
	int calculate(char [] array){
		int i=0, count=0;
		while(i != array.length){
			if(array[i] == ')' && isEmpty()){
				i++;
				continue;
			}
			
			if(array[i] == ')' && peek() == '('){
				pop();
				count += 2;
			}
			
			else if(array[i] == '('){
				push(array[i]);
			}
			i++;
		}
		
		return count;
	}
	
	
}
class LongestParenthesis{
	static Scanner inp = new Scanner(System.in);
	public static void main(String [] args){
		
		String str = inp.next();
		Stack obj = new Stack(str.length());
		
		System.out.println(obj.calculate(str.toCharArray()));
	}
}