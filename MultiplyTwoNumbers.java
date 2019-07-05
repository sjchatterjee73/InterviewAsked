package algo;

public class MultiplyTwoNumbers {
	class List{
		List next;
		int node;
		public List(int node) {
			this.node = node;
			this.next = null;
		}
	}
	
	List add(String num, int key) {
		List temp = null;
		int carry = 0, token = 0;
		for(int i=num.length()-1; i>=0; i--) {
			int k = (int)num.charAt(i)-'0';
			token += (k * key);
			
			if(token > 9) {
				carry = token / 10;		
				token = token % 10;						
			}
			List newnode = new List(token);
			newnode.next = temp;
			temp = newnode;
			token = carry;
			carry=0;
		}
		if(token > 0) {
			List newnode = new List(token);
			newnode.next = temp;
			temp = newnode;
		}
		return temp;
	}
	void display(List head) {
		if(head == null) return;
		
		System.out.print(head.node+", ");
		display(head.next);
	}
	
	void addList(List list1, List list2) {
		List l1 = list1;
		List l2 = list2;
		
		while(l1 != null) {
			l1.node += l2.node;
			l1 = l1.next;
			l2 = l2.next;
		}
	}
    public String multiply(String num1, String num2) {
    	List [] array = new List[num2.length()];
    	int m = 0;
    	for(int i=array.length-1; i>=0; i--) {
    		array[m++] = add(num1, (int)num2.charAt(i)-'0');
    	}
    	for(int i=0; i<array.length; i++) {
    		display(array[i]);
    		System.out.println();
    	}
    	
    	for(int i=1; i<array.length; i++) {
    		addList(array[0], array[i]);
    	}
    	display(array[0]);
    	return "";
    }
    public static void main(String[] args) {
    	String num1 = "66";
    	String num2 = "66";
    	if(num1.length() > num2.length()) {
    		System.out.println(new MultiplyTwoNumbers().multiply(num1, num2));
    	}else {
    		System.out.println(new MultiplyTwoNumbers().multiply(num2, num1));
    	}
    		
	}
}
