/* 
	Given two number in string format. Add these numbers. 
	
	1. traverse the string in backward direction.
	2. calculate sum of each n-th digit from two string and put in any string or list
	3. return the list or string
	
	coder. : sj .:) 
*/

public class AddTwoNumbers {
    class List{
        int node;
        List next;
        
        public List(int node){
            this.node = node;
            this.next = null;
        }
    }
	List add(List head, char num){
		if(head == null) return new List((int)num-'0');
		
		head.next = add(head.next, num);
		
		return head;
	}
	
	List getSum(List list1, List list2){
		List temp = new List(0);
		List flag = temp;
		
		int carry = 0;
		int sum =0 ;
		List l1 = list1, l2 = list2;
		
		while(l1 != null || l2 != null){
			//System.out.println("sd");
			if(l1 != null){
				sum += l1.node;
				l1 = l1.next;
			}
			
			if(l2 != null){
				sum += l2.node;
				l2 = l2.next;
			}
			
			if(sum > 9){
				sum -= 10;
				carry = 1;									
			}
			List node = new List(sum);
			node.next = flag;
			flag = node;
			sum = 0;
			sum += carry;
			carry = 0;
		}
		if(sum > 0){
			List node = new List(sum);
			node.next = flag;
			flag = node;									
		}
		
		return flag;
	}
    public String addStrings(String num1, String num2) {
			List list1 = null;
			List list2 = null;
			
			for(int i=num1.length()-1; i>=0; i--){
				list1 = add(list1, num1.charAt(i));
			}
			
			for(int i=num2.length()-1; i>=0; i--){
				list2 = add(list2, num2.charAt(i));
			}
			
			List list3 = getSum(list1, list2);
			String sum = "";
			
			while(list3.next != null) {
				sum += list3.node;
				list3 = list3.next;
			}
			return sum;
    }
    
    public static void main(String[] args) {
    	
		System.out.println(new AddTwoNumbers().addStrings("99999999999999999999999999999999", "1"));
	}
}
