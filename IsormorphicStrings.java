/*
Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
*/

import java.util.*;

class IsomorphicStrings{
	static LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	static LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<Character, Integer>();

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("enter first string:");
		String first = inp.next();
		System.out.println("enter second string:");
		String second = inp.next();
		System.out.println(driver(first, second));
	}

	static boolean driver(String first, String second){
		if(first.length() != second.length())
			return false;


		String check = "", check1="";
		for(int i=0; i<first.length(); i++){
			if(!contains(first.charAt(i), check)){
				map.put(first.charAt(i), getOccurance(first.charAt(i), first));
			}

			if(!contains(second.charAt(i), check1)){
				map1.put(second.charAt(i), getOccurance(second.charAt(i), second));
			}
		}

		if(map.size() != map1.size())
			return false;

		for(int i=0; i<map.size(); i++){
			int val = (new ArrayList<Integer>(map.values())).get(i);
			int val1 = (new ArrayList<Integer>(map.values())).get(i);
			if(val != val1)
				return false;
		}
		return true;
	}
	static boolean contains(char c, String str){
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == c)
				return true;
		}
		return false;
	}
	static int getOccurance(char c, String str){
		int count=0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == c)
				count++;
		}
		return count;
	}
}