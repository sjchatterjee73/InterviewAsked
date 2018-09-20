/*
  Given two words (start and end), and a dictionary, find the length of shortest 
  transformation sequence from start to end, such that only one letter can be changed at a time
  and each intermediate word must exist in the dictionary. For example, given:
  start = "hit"
  end = "cog"
  dict = ["hot","dot","dog","lot","log"]
  One shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program
  should  print the shortest path: hit -> hot -> dot -> dog -> cog.
*/

import java.util.*;
class WordLadder2{
  static String [] array = {"hot","dot","dog","lot","log"};
  static String first = "hit";
  static String second = "cog";  
  static String f = "";  
  static String print = "";
  public static void main(String[] args) {        
    print += first+"->";
    get();
    System.out.println(print);
  }  
  static void get(){
    int count=0;
    while(true){
      if(count++ >= array.length * array.length){
        System.out.println("not possible to traverse!");
        return;
      }
      int traverse = check(first, array);
      first = f;
      print += f +"->";
      array[traverse] = "";

      if(first.length() == 0)
        break;
      if(count > array.length*array.length)
		    break;
      
      if(subCheck(first, second)){
        print += second;
        return;
      }
    }    
  }
  static int check(String first, String [] array){
    for(int i=0; i<array.length; i++){
      if(subCheck(first, array[i])){
        f = array[i];
        return i;
      }
    }
    return 0;
  }
  
  static boolean subCheck(String first, String temp){
    int len = first.length();
    int count=0;
    for(int i=0; i<first.length(); i++){
      String s = first.charAt(i)+"";
      if(temp.contains(s))
        count++;
    }
    if(len-1 == count)
      return true;
    return false;
  }
}