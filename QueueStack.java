/*
	Reverse k elements from Queue.
	Only following standard operations are allowed on queue.
	enqueue(x) : Add an item x to rear of queue
	dequeue() : Remove an item from front of queue
	size() : Returns number of elements in queue.
	front() : Finds front item.
	
	Naive Approach:
	1. Enqueue all N elements.
	2. Dequeue first K elements.
	3. Push all K elements in stack.
	4. Pop all elements from stack.
	5. Dequeue all elements from stack.
*/

import java.util.*;

class QueueStack{
	static int max, rear, front, top;
	static int [] queue;
	static int [] stack;
	
	static Scanner inp = new Scanner(System.in);
	 
	public QueueStack(int n, int k){
		max = n;
		rear = -1;
		front = 0;
		top = -1;
		queue = new int[n];
		stack = new int[k];
	}
	
	static void enqueue(int elem){
		if(rear == max-1){
			System.out.println("Queue Overflowing!");
			return;
		}
		
		queue[++rear] = elem;
	}
	static int dequeue(){
		int temp = queue[front++];
		rear = rear -1;
		return temp;
	}
	static boolean isEmpty(){
		if(rear == -1){
			front = 0;
			return true;
		}
		
		return false;
	}
	static void push(int elem){
		stack[++top] = elem;
	}
	static int pop(){
		return stack[top--];
	}
	static boolean isEmptyStack(){
		return (top == -1);
	}
	public static void main(String [] args){	
		int n = inp.nextInt();
		int k = inp.nextInt();
		
		new QueueStack(n, k);
		
		System.out.println("Enter "+n+" elements in Queue!");
		for(int i=0; i<n; i++){
			System.out.println("Enqueue() " + (i+1) + "-th Element");
			enqueue(inp.nextInt());
			System.out.println("Item is enqueued!");
		}
		
		while(k--> 0){
			push(dequeue());
		}
		
		while(!isEmptyStack()){
			System.out.print(pop());
		}
		while(!isEmpty()){
			System.out.print(dequeue());
		}
	}
}