/*
Given two words (start and end), and a dictionary, find the length of shortest transfor-
mation sequence from start to end, such that only one letter can be changed at a time
and each intermediate word must exist in the dictionary. For example, given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
*/
import java.util.*;
class WordLadder2{
  static String [] array = {"hot","dot","log", "pot","pit", "cig"};
  static String first = "mot";
  static String second = "pig";
  static String f = "";
  static String s = "";
  public static void main(String[] args) {
    System.out.println(get()+2);
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

      System.out.println("first: "+first);
      if(subCheck(first, second))
        return count;

      System.out.println("now array is:");
      for(int i=0; i<array.length; i++){
        System.out.print(array[i]+"->");
      }
      System.out.println();
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
