/*
	given a string with space; convert it into URL format [such that every space will be replaced by '%20'];
	approach: 
	1. count number of space a string having.
	2. henever a space is found, take the string back two index
	3. continue until every space is replace with [%20]
	
	coder. : sj. :)
*/

public class Shift {
	private static int getSpace(String name) {
		int count = 0;
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i) == ' ') count++;
		}
		return count;
	}
	
	private static void getInArray(char [] array, String name) {
		for(int i=0; i<name.length(); i++) {
			array[i] = name.charAt(i);
		}
	}
	private static void shift(char [] array, int index) {
		for(int i = array.length-1; i>=index; i--) {
			if(i == 0) break;
			array[i] = array[i-1];
		}		
	}
	private static void swap(char [] array) {
		for(int i=0; i<array.length; i++) {
			if(array[i] == ' ') {
				shift(array, i);
				shift(array, i);
				array[i] = '%';
				array[i+1] ='2';
				array[i+2] = '0';			
			}
		}
	}
	public static void main(String[] args) {
		String name = "   ";
		char [] array = new char[name.length() + (getSpace(name)*2)];
		getInArray(array, name);
		
		swap(array);
		System.out.println(array);
	}
}
