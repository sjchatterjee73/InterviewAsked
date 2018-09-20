/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time
and each intermediate word must exist in the dictionary. For example, given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

One shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program should return its length 5
*/

import java.util.*;
class WordLadder{
  static String [] array = {"hot","dot","dog","lot","log"};
  static String first = "hit";
  static String second = "cog";
  static String f = "";
  static String s = "";
  public static void main(String[] args) {
    int count = get();
    if(count == 0)
      System.out.println("not possible to traverse");
    else if(count >= array.length * array.length)
      System.out.println("not possible to travarse");
    else
      System.out.println(count+2);
  }
  static int get(){
    int count=0;
    while(true){
      ++count;
      int traverse = check(first, array);
      int traverse1 = check1(first, array);

      if(traverse >= traverse1){
        first = f;
        array[traverse]= "";
      }

      else{
        first = s;
        array[traverse1] = "";
      }

      if(first.length() == 0)
        break;
      if(count > array.length*array.length)
		break;
      if(subCheck(first, second))
        return count;
    }
    return count;
  }
  static int check1(String first, String [] array){
    for(int i=array.length-1; i>=0; i--){
      if(subCheck(first, array[i])){
        s = array[i];
        return i;
      }
    }
    return 0;
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
