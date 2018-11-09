/*
	You are given a sorted array with duplicates value. You have to make the array, distinct such that all elements in array become unique.
	
	Naive Approach:
	1. we take two place holder, such as first(you can say prev. for better understanding) and second.
	2. we will match first and second place holder repeatedly.
		2.1 if both place holder holds same value (means, duplicate found)
			2.1.1 we will skip the value.
		2.2 else
			2.2.2 we will not skip the value.
	3. we will repeat until the end of list.
	
	------
	list prev = head;
	list afterprev = head.next;
	
	while(afterprev is not null){
		if(prev == afterprev)
			prev.next = afterprev.next;
		else
			prev = afterprev;
		
		afterprev = afterprev.next;
	}
	
	return head;
	------
*/
import java.util.*;

class Nodes{
	int data;
	Nodes next;
	
	public Nodes(int data){
		this.data = data;
		next = null;
	}
}

class List{	
	Nodes push(int data, Nodes head){
		Nodes newitem = new Nodes(data);
	
		if(head == null)
			head = newitem;
	    else if(head.next == null)
			head.next = newitem;
		else{
			Nodes temp = head;
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newitem;
		}
		return head;
	}
	void display(Nodes head){
		Nodes temp = head;
		while(temp != null){
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
		return;
	}
	Nodes distincts(Nodes head){
			Nodes prevTemp = head;
			Nodes temp = head.next;
			
			while(temp != null){
				if(prevTemp.data == temp.data)
					prevTemp.next = temp.next;
				else
					prevTemp = temp;
				
				temp = temp.next;
			}
			
			return head;
	}
}
class DistinctNodes{
	public static void main(String [] args){
		Nodes head = null;
		
		int [] array = {1,1,1,2,2,2,2,3,3,4,5};		
		List obj = new List();
		
		for(int i=0; i<array.length; i++){
			head = obj.push(array[i], head);
		}
		
		obj.display(head);
		
		head = obj.distincts(head);
		obj.display(head);		
	}
}