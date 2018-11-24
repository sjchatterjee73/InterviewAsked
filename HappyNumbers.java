/*
	Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

*/
import java.util.*;
class List{
	List next;
	int data;

	public List(int data){
		this.data = data;
		next = null;
	}
}

class Numbers{
	List head;
	int k;
	public Numbers(){
		head = null;
		k = 0;
	}	
	void pushElement(int elem){
		List newitem = new List(elem);
		newitem.next = null;

		if(head == null){
			head = newitem;				
		}else if(head.next == null){
			head.next = newitem;
		}else{
			List temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newitem;
		}
	}
	boolean contains(int data){
		List temp = head;
		while(temp != null){
			if(temp.data == data){				
				return true;
			}

			temp = temp.next;
		}
		return false;
	}
	
	boolean display(int elem){
		pushElement(elem);
		if(elem < 0 || elem > 10000 || k > 100)
			return false;

		if(elem == 1)
			return true;
		
		String temp = elem+"";
		int num = 0;
		for(int i=0; i<temp.length(); i++){
			int t = (int) temp.charAt(i) - '0';
			num += (t * t);
		}
		
		if(num == elem)
			return false;	
		++k;

		if(contains(num))			
			return false;
		return display(num);		
	}
}
class HappyNumbers{
	static Scanner inp = new Scanner(System.in);
	static int t;
	public static void main(String[] args) {
		t = inp.nextInt();		
		while(t-- >0){
			Numbers obj = new Numbers();
			System.out.println(obj.display(inp.nextInt()));
		}
	}
}