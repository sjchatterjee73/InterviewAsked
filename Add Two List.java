import java.util.*;

class List{
	int value;
	List next;

	public List(int value){
		this.value = value;
		next = null;
	}
}

class Driver {
	List push(List head, int item){
		List newitem = new List(item);
		if(head == null){
			head = newitem;
		}else{
			newitem.next = head;
			head = newitem;
		}
		return head;
	}

	void display(List head){
		List temp = head;
		while(temp != null){
			System.out.print(temp.value +" -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	List addBothList(List head, List head1){
		int carryOver =0 ;
		List temp = new List(0);
		List pointer = temp;
		int digit = 0;
		List l1 = head;
		List l2 = head1;
		int sum =0;
		while(l1 != null || l2 != null){
			 sum = 0;
			if(l1 != null){
				sum += l1.value;
				l1 = l1.next;
			}

			if(l2 != null){
				sum += l2.value;
				l2 = l2.next;
			}

			sum += carryOver;

			carryOver = (sum >= 10) ? 1: 0;
			pointer.next = new List(sum % 10);
			pointer  = pointer.next;
		}
		
		if((sum/10) != 0)
		{
			pointer.next = new List(sum /10);
			pointer = pointer.next;
		}

	return temp.next;
	}
}

class AddList{
	static Scanner inp = new Scanner(System.in);
	public static void main(String[] args) {
		int t = inp.nextInt();
		Driver obj = new Driver();

		while(t-- > 0){
			List head = null;
			List head1 = null;
			List resultHead = null;
			int n = inp.nextInt();
			int n1 = inp.nextInt();

			System.out.println("Enter Values of First List: ");
			for(int i=0; i<n; i++){
				head = obj.push(head, inp.nextInt());
			}
			System.out.println("Enter Values of Second List: ");
			for(int i=0; i<n1; i++){
				head1 = obj.push(head1, inp.nextInt());
			}

			System.out.println("First List:");
			obj.display(head);
			System.out.println("Second List:");
			obj.display(head1);

			resultHead = obj.addBothList(head, head1);
			obj.display(resultHead);

		}
	}
}