import java.util.*;

class List{
	int d, d1;
	List ListNext;
	List(int d, int d1){
		this.d = d;
		this.d1 = d1;
		ListNext = null;
	}
}
class Stack{
	int data;
	Stack StackNext;

	Stack(int data){
		this.data = data;
		StackNext = null;
	}
}
class Driver{
	Stack StackHead = null;
	List ListHead = null;

	void push(int elem){
		Stack newelem = new Stack(elem);

		if(StackHead == null){
			StackHead = newelem;
		}else if(StackHead.StackNext == null){
			StackHead.StackNext = newelem;
		}else{
			newelem.StackNext = StackHead;
			StackHead = newelem;
		}
	}

	int pop(){
		int top = StackHead.data;
		StackHead = StackHead.StackNext;
		return top;
	}

	boolean isEmpty(){
		return (StackHead == null);
	}

	int getSizeOfStack(){
		Stack temp = StackHead;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.StackNext;
		}
		return count;
	}
	void addLast(int elem){
		Stack newelem = new Stack(elem);

		if(StackHead == null){
			StackHead = newelem;
		}else if(StackHead.StackNext == null){
			StackHead.StackNext = newelem;
		}else{
			Stack temp = StackHead;
			while(temp.StackNext != null)
				temp = temp.StackNext;

			temp.StackNext = newelem;
		}
	}
	void addOnList(int first, int second){
		List  items = new List(first, second);
		if(ListHead == null){
			ListHead = items;
		}else if(ListHead.ListNext == null){
			ListHead.ListNext = items;
		}else{
			List temp = ListHead;
			while(temp.ListNext != null)
				temp = temp.ListNext;

			temp.ListNext = items;
		}
	}
	void function(){		
		int second = pop();
		int size = getSizeOfStack();

		while(size-- > 0){
			int third = pop();						
			addOnList(second, third);
			addLast(third);
		}		
	}
	void getElements(int [] array, int i, int j, int k){
		if(ListHead == null || (j == array.length-2))
			return;

		List temp = ListHead;
		while(temp != null){			
			if(array[i] + temp.d + temp.d1 == k)
				System.out.println(array[i]+""+temp.d+""+temp.d1);
			temp = temp.ListNext;			
		}

		getElements(array, i+1, j+1, k);
	}
	void getSums(int [] array, int k){
		for(int i=array.length-1; i>=1; i--)
			push(array[i]);

		for(int i=0; i<array.length-1; i++)
			function();

		getElements(array, 0, 0+1, k);
			
	}
}

class ThreeSum{
	public static void main(String[] args) {
		int [] array = {-1, 0, 1, 2, -4, -1};
		int k = 0;
		
		new Driver().getSums(array, k);
	}
}